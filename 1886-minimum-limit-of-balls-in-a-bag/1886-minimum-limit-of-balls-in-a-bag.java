class Solution {
    public static int getMax(int[] nums){
        int max = -1;
        for(int i = 0;i < nums.length; i++){
            max = Math.max(max, nums[i]);
        }
        return max;
    }
    public int minimumSize(int[] nums, int maxOperations) {
        int low = 1;
        int high = getMax(nums);
        int mid = 0;
        int answer = 0;
        int operations = 0;
        while(low <= high){
            mid = (low + high) >> 1;
            operations = 0;

            for(int i = 0; i < nums.length; i++){
                if(nums[i] > mid){
                    if(nums[i] % mid == 0){
                        operations += nums[i]/mid - 1;
                    }
                    else{
                        operations += nums[i]/mid;
                    }
                }
            }
            System.out.println(operations);
            if(operations <= maxOperations){
                answer = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }   
        return answer;
    }
}