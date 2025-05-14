class Solution {
    private int getMincost(int i, int j, int [] nums, int [][] dp){
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int mini = Integer.MAX_VALUE;
        for(int index = i; index <= j; index++){
            int answer = nums[j + 1] - nums[i - 1] + getMincost(i, index - 1, nums, dp) + getMincost(index + 1, j, nums, dp);
            mini = Math.min(mini, answer);
        }
        dp[i][j] = mini;
        return mini;
    }
    public int minCost(int n, int[] cuts) {
        int size = cuts.length;
        int [][] dp = new int[size + 2][size + 2];
        int [] nums = new int[size + 2];
        for(int i = 0; i < size; i++){
            nums[i] = cuts[i];
            Arrays.fill(dp[i], -1);
        }
        for(int i = 0; i < size + 2; i++){
            Arrays.fill(dp[i], -1);
        }
        nums[size] = 0;
        nums[size + 1] = n;
        Arrays.sort(nums);
        int answer = getMincost(1, size, nums, dp);
        return answer;
    }
}