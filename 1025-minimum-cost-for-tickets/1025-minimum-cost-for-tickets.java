class Solution {
    public static int getminimumCost(int index, int range, int [] days, int [] costs, int size, int [][] dp){
        if(index >= size) return 0;
        if(dp[index][range] != -1) return dp[index][range];
        if(range >= days[index]) return getminimumCost(index + 1, range, days, costs, size,dp);
        int oneDaypass = costs[0] + getminimumCost(index + 1, days[index], days, costs, size,dp);
        int sevenDaypass = costs[1] + getminimumCost(index + 1, days[index] + 6, days, costs, size,dp);
        int fifteenDaypass = costs[2] + getminimumCost(index + 1, days[index] + 29, days, costs, size,dp);
        dp[index][range] = Math.min(Math.min(oneDaypass, sevenDaypass), fifteenDaypass);
        return dp[index][range];
    }   
    public int mincostTickets(int[] days, int[] costs) {
        int size = days.length;
        int range = days[size - 1] + 30;
        int [][] dp = new int[size][range];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        int answer = getminimumCost(0, 0, days, costs, size, dp);
        return answer;
    }
}