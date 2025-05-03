class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int size_difficulty = difficulty.length;
        int size_worker = worker.length;
        int [][] temp = new int[size_difficulty][2];
        int [] prefix_max = new int[size_difficulty];
        int answer = 0;
        int low = 0;
        int high = 0;
        int mid = 0;
        int index = -1;

        /* 2 CROSS N Temp Array */
        for(int i = 0; i < size_difficulty; i++){
            temp[i][0] = difficulty[i];
            temp[i][1] = profit[i];
        }
        /* Sorting the array based on first */
        Arrays.sort(temp, (a, b) -> a[0] - b[0]);

        /* Prefix max_array*/
        prefix_max[0] = temp[0][1];
        for(int i = 1; i < size_difficulty; i++){
            prefix_max[i] = Math.max(prefix_max[i - 1], temp[i][1]);
        }
        
        for(int i = 0; i < size_worker; i++){
            int wrkr = worker[i];
            low = 0;
            high = size_difficulty - 1;
            index = -1;
            while(low <= high){
                mid = low + high >> 1;
                int value = temp[mid][0];
                if(wrkr >= value){
                    index = mid;
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
            if(index != -1){
                answer += prefix_max[index];
            }
        }
    return answer;
    }
}