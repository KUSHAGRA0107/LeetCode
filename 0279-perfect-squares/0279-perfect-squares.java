class Solution {
    public int getMinimum(int number, int [] dp){
        if(number == 0) return 0;
        if(dp[number] != -1) return dp[number];
        int min = Integer.MAX_VALUE;
        for(int i = 1; i * i <= number; i++){
            min = Math.min(min, 1 + getMinimum(number - i * i, dp));
        }
        dp[number] = min;
        return min;
    }
    public int numSquares(int n) {
        int [] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int min = getMinimum(n, dp);
        return min;
    }
}