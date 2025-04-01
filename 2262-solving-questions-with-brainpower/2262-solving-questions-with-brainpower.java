class Solution {
    public long getMaximum(int index,int [][] questions, long [] dp){
        if(index >= questions.length) return 0;
        if(dp[index] != -1) return dp[index];
        long take = questions[index][0] + getMaximum(index + questions[index][1] + 1, questions, dp);
        long not_take = getMaximum(index + 1, questions, dp);
        return dp[index] = Math.max(take, not_take);
    }
    public long mostPoints(int[][] questions) {
        int index = 0;
        long [] dp = new long[questions.length];
        Arrays.fill(dp, -1);
        long answer = getMaximum(index,questions,dp);
        return answer;
    }
}