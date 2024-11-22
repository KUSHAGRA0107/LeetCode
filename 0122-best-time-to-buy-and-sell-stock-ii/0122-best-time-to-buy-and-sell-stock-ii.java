class Solution {
    public int getmaxProfit(int index, int canBuy, int [] prices, int [][] dp){
        int length = prices.length;
        if(index == length){
            return 0;
        }
        int answer = 0;
        if(dp[index][canBuy] != -1){
            return dp[index][canBuy];
        }
        if(canBuy ==  1){
            int take = -prices[index] + getmaxProfit(index + 1, 0,prices,dp);
            int not_take = getmaxProfit(index + 1, 1,prices,dp);
            answer = Math.max(take, not_take);
        }
        else{
            int take = prices[index] + getmaxProfit(index + 1, 1,prices,dp);
            int not_take = getmaxProfit(index + 1, 0,prices,dp);
            answer = Math.max(take, not_take);
        }
        dp[index][canBuy] = answer;
        return answer;
    }
    public int maxProfit(int[] prices) {
        int [][] dp = new int [prices.length][2];
        for(int i = 0; i < prices.length; i++){
            for(int j = 0; j < 2; j++){
                dp[i][j] = -1;
            }
        }
        int answer = getmaxProfit(0,1,prices,dp);
        return answer;

    }
}