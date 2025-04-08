class Solution {
    public int getLIS(int index, int prev_index, int [] nums, int [][] dp){
        int size = nums.length, answer = 0;
        if(index == size) return 0;
        if(dp[index][prev_index + 1] != -1) return dp[index][prev_index + 1];
        if(prev_index == -1 || nums[index] > nums[prev_index]){
            answer = 1 + getLIS(index + 1, index, nums, dp);
        }
        answer = Math.max(answer, getLIS(index + 1, prev_index, nums, dp));
        dp[index][prev_index + 1] = answer;
        return answer;
    }
    public int lengthOfLIS(int[] nums) {
        int size = nums.length;
        int [][] dp = new int[size][size + 1];
        for(int i = 0;i < size; i++) Arrays.fill(dp[i], -1);
        int answer = getLIS(0, -1, nums, dp);
        return answer;
    }
}