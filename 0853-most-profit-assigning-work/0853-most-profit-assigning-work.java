class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        /* We will sort the task in ascending order difficulty wise
        so that worker has a choice to perform only certain task such 
        that all the  task before the threshold(binary-search) can be performed by the worker
        and also the max of all those will be the one that the worker will perform
        (prefix-max-array)
        */
        int size = difficulty.length;
        int [][] nums = new int[size][2];
        int answer = 0;
        int [] max_profit = new int[size];
        for(int i = 0; i < size; i++){
            int diff = difficulty[i];
            int prof = profit[i];
            nums[i][0] = diff;
            nums[i][1] = prof;
        }
        Arrays.sort(nums, (a,b) -> a[0] - b[0]);
        max_profit[0] = nums[0][1];
        for(int i = 1; i < size; i++){
            max_profit[i] = Math.max(max_profit[i - 1], nums[i][1]);
        }

        for(int i = 0; i < worker.length ; i++){
            int labour = worker[i];
            int low = 0;
            int high = size - 1;
            int index = -1;
            while(low <= high){
                int mid = (low + high) >> 1;
                int value = nums[mid][0];
                if(labour >= value){
                    index = mid;
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
            if(index != -1){
                answer += max_profit[index];
            }
        }
        return answer;
    }
}