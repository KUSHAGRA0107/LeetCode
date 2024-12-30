class Solution {
    static int mod = 1000000007;
    public static int getCount(int low, int high, int zero, int one, int length, int [] dp){
        if(length > high) return 0;
        if(dp[length] != -1) return dp[length];
        int result = 0;
        if(length >= low) result = 1;
        result += getCount(low, high, zero, one, length + zero, dp) + getCount(low, high, zero, one, length + one, dp);
        dp[length] = result % mod;
        return dp[length];
    }
    public int countGoodStrings(int low, int high, int zero, int one) {
        int [] dp = new int[high + 1];
        for(int i = 0;i < dp.length; i++) dp[i] = -1;
        int answer = getCount(low, high, zero, one, 0, dp);
        return answer;
    }
}