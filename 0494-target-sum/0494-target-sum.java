class Solution {
    public int targetSum(int index, int [] nums, int target){
        if(index == nums.length){
            if(target == 0) return 1;
            return 0;
        }
        int left = targetSum(index + 1, nums, target - nums[index]);
        int right = targetSum(index + 1, nums, target + nums[index]);
        // dp[index][target + factor] = left + right;
        return left + right;

    }
    public int findTargetSumWays(int[] nums, int target) {
        // int [][] dp = new int[nums.length][2 * target];
        // for(int i = 0; i<dp.length; i++)Arrays.fill(dp[i], -1);
        int answer = targetSum(0, nums, target);
        return answer;
    }
}