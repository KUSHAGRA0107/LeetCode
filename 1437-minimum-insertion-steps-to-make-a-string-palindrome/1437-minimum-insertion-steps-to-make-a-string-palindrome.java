class Solution {
    public int getMinOperation(String s, int i, int j, int [][] dp){
        if(i >= j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == s.charAt(j)){
            dp[i][j] = getMinOperation(s, i + 1, j - 1, dp);
        }
        else{
        dp[i][j] =  1 + Math.min(getMinOperation(s,i, j - 1, dp),
            getMinOperation(s, i + 1, j, dp));
        }
        return dp[i][j];
    }
    public int minInsertions(String s) {
        int [][] dp = new int[s.length()][s.length()];
        for(int i = 0; i < dp.length; i++)Arrays.fill(dp[i], -1);
        int answer = getMinOperation(s, 0, s.length() - 1, dp);
        return answer;
    }
}