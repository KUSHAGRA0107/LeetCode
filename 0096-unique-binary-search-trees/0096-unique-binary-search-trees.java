class Solution {
    public int getCount(int n, int [] dp){
        if(n <= 1) return 1;
        if(dp[n] != -1) return dp[n];
        int total = 0;
        for(int i = 1; i <= n; i++){ 
            total += getCount(i - 1, dp) * getCount(n - i, dp);
        }
        dp[n] = total;
        return total;
    }
    public int numTrees(int n) {
        int [] dp = new int[n + 1];
        Arrays.fill(dp,-1);
        int answer = getCount(n, dp);
        return answer;
    }
}