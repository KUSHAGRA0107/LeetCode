class Solution {
    public static int getLongestSubsequence(int index, int target, List<Integer> nums, int [][] dp){
        if(target == 0){
            return 0;
        }
        if(target < 0 || index >= nums.size()) return Integer.MIN_VALUE;
        if(dp[index][target] != -1) return dp[index][target];
        int take = 1 + getLongestSubsequence(index + 1, target - nums.get(index), nums, dp);
        int not_take = getLongestSubsequence(index + 1, target, nums, dp);
        dp[index][target] = Math.max(take, not_take);
        return dp[index][target];
    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int [][] dp = new int[nums.size()][target + 1];
        for(int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
        int answer = getLongestSubsequence(0, target, nums, dp);
        if(answer <= 0) return -1;
        return answer;
    }
}