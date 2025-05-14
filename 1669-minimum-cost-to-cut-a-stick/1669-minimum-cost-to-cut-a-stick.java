class Solution {
    public int minCost(int n, int[] cuts) {
        int size = cuts.length;
        int [][] dp = new int[size + 2][size + 2];
        int [] nums = new int[size + 2];
        for(int i = 0; i < size; i++) nums[i] = cuts[i];
        nums[size] = 0;
        nums[size + 1] = n;
        Arrays.sort(nums);
        for(int i = size; i >= 1; i--){
            for(int j = i ; j <= size; j++){
               
                int min = Integer.MAX_VALUE;
                for(int index = i; index <= j; index++){
                    int answer = nums[j + 1] - nums[i - 1] + dp[i][index - 1] + dp[index + 1][j];
                    min = Math.min(min, answer);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][size];
    }
}