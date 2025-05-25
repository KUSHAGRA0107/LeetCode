class Solution {
    public int getMax(int index, int k, int [] arr, int n, int [] dp){
        if(index >= n) return 0;
        if(dp[index] != -1) return dp[index];
        int answer = 0;
        int currMax = 0;

        for(int j = index; j < Math.min(index + k, n); j++){
            currMax = Math.max(currMax, arr[j]);
            int cost = (j - index + 1) * currMax + getMax(j + 1, k, arr, n, dp);
            answer = Math.max(answer, cost);
        }
        return dp[index] = answer;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int [] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return getMax(0, k, arr, arr.length, dp);   
    }
}