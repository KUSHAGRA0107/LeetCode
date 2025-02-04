class Solution {
    public int getLongest(int i, int j, String s, int [][]dp){
        if(i > j) return 0;
        if(i == j) return 1;
        if(dp[i][j] != -1)return dp[i][j];
        if(s.charAt(i) == s.charAt(j)) return 2 + getLongest(i + 1, j - 1, s, dp);
        dp[i][j] = Math.max(getLongest(i + 1, j, s, dp), getLongest(i, j - 1, s, dp));
        return dp[i][j];
    }
    public int longestPalindromeSubseq(String s) {
        int [][] dp = new int[s.length()][s.length()];
        for(int i = 0; i<s.length(); i++)Arrays.fill(dp[i], -1);
        int answer = getLongest(0, s.length() - 1, s, dp);
        return answer;
    }
}