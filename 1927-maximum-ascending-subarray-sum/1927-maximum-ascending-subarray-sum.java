class Solution {
    public int maxAscendingSum(int[] nums) {
        int answer = 0;
        int size = nums.length;
        int sum = nums[0];
        for(int i = 1; i < size; i++){
            if(nums[i] <= nums[i - 1]){
                answer = Math.max(answer, sum);
                sum = 0;
            }
            sum += nums[i];
        }
        answer = Math.max(answer, sum);
        return answer;
    }
}