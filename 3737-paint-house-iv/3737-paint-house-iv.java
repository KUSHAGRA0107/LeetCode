class Solution {
    public long getMincost(int index, int prev1, int prev2, int [][] cost, int size, long [][][] dp){
        if(index >= size/2)return 0;
        if(dp[index][prev1][prev2] != -1)return dp[index][prev1][prev2];
        long answer = Long.MAX_VALUE;
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                if(i != j && prev1 != i && prev2 != j){
                    answer = Math.min(answer,
                    cost[index][i] + cost[size - index - 1][j]+
                    getMincost(index + 1, i, j, cost, size, dp)
                    );
                }
            }
        }
        dp[index][prev1][prev2] = answer;
        return answer;
    }
    public long minCost(int n, int[][] cost) {
        long [][][] dp = new long[cost.length][4][4];
        for(int i = 0; i<cost.length;i++){
            for(int j = 0; j<4;j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        long answer = getMincost(0, 3, 3, cost, cost.length, dp);
        return answer;
    }
}