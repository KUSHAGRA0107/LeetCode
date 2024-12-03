class Solution {
    public static int helper(int start, int end, int turn, int alice, int bob, int [] piles, int [][] dp){
        if(start >= end){
            if(alice > bob){
                return 1;
            }
            return 0;
        }
        if(dp[start][end] != -1){
            return dp[start][end];
        }
        int beginning, ending = 0;
        if(turn == 0){
            beginning =  helper(start + 1, end, 1 - turn, alice + piles[start], bob, piles, dp);
            ending = helper(start, end - 1, 1 - turn, alice + piles[end], bob, piles, dp);
        }
        else{
            beginning =  helper(start + 1, end, 1 - turn, alice , bob + piles[start], piles, dp);
            ending = helper(start, end - 1, 1 - turn, alice, bob + piles[end], piles, dp);
        }
        dp[start][end] = Math.max(beginning, ending);
        return dp[start][end];
    }
    public boolean stoneGame(int[] piles) {
        int [][] dp = new int[piles.length][piles.length];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        int answer = helper(0, piles.length - 1,0,0,0,piles, dp);
        if(answer == 1){
            return true;
        }
        return false;
    }
}