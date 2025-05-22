class Solution {
    public int helper(int i, int j, String s1, String s2, int [] s1Arr, int [] s2Arr, int m, int n, int [][] dp){
        if(i == m && j == n) return 0;
        if(i == m) return s2Arr[j];
        if(j == n) return s1Arr[i];
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)) return helper(i + 1, j + 1, s1, s2, s1Arr, s2Arr, m, n, dp);
        return dp[i][j] = Math.min((int)s1.charAt(i) + helper(i + 1, j, s1, s2, s1Arr, s2Arr, m, n, dp), (int) s2.charAt(j) + helper(i, j + 1, s1, s2, s1Arr, s2Arr, m, n, dp));
    }
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int [] s1Arr = new int[m];
        s1Arr[m - 1] = (int) s1.charAt(m - 1);
        for(int i = m - 2; i >= 0; i--){
            s1Arr[i] = (int) s1.charAt(i) + s1Arr[i + 1];
        }
        int [] s2Arr = new int[n];
        s2Arr[n - 1] = (int) s2.charAt(n - 1);
        for(int i = n - 2; i >= 0; i--){
            s2Arr[i] = (int) s2.charAt(i) + s2Arr[i + 1];
        }
        int [][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i], -1);
        }
        int answer = helper(0, 0, s1, s2, s1Arr, s2Arr, m, n, dp);
        return answer;
    }
}