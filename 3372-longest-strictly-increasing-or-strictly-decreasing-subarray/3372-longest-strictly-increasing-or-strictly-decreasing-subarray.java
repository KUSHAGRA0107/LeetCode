class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int increasingCount = 1;
        int decreasingCount = 1;
        int answer = 1;
        int size = nums.length;
        for(int i = 1; i < size; i++){
            // this is to check the increasingSubArray
            if(nums[i] > nums[i - 1]){
                increasingCount++;
                decreasingCount = 1;
            }
            // this is to check decreasing SubArray
            else if(nums[i] < nums[i - 1]){
                increasingCount = 1;
                decreasingCount++;
            }
            else{
               increasingCount = 1;
               decreasingCount = 1;
            }
            answer = Math.max(answer, Math.max(increasingCount, decreasingCount));
        }
        return answer;
    }
}