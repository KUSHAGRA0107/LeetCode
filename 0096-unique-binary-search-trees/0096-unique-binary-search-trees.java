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
    public int solveTabulation(int n){
        int [] answer = new int[n + 1];
        for(int i = 0; i <= n ; i++) answer[i] = 1;

        for(int nodes = 2; nodes <= n; nodes++){
            int total = 0;
            for(int root = 1; root <= nodes; root++){
                total += answer[root - 1] * answer[nodes - root];
            }
            answer[nodes] = total;
        }
        return answer[n];
    }
    public int numTrees(int n) {
        int [] dp = new int[n + 1];
        Arrays.fill(dp,-1);
        int answer = solveTabulation(n);
        return answer;
    }
}