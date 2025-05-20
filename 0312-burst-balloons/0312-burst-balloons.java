class Solution {
    public int getMax(int i, int j, int [] nums, int [][] dp){
        if(i > j) return 0;
        if(dp[i][j] != -1) return  dp[i][j];
        int maxi = Integer.MIN_VALUE;
        for(int index = i; index <= j; index++){
            maxi = Math.max(maxi,
            nums[i - 1] * nums[index] * nums[j + 1] + getMax(i, index - 1, nums, dp) + getMax(index + 1 , j, nums, dp));
        }
        dp[i][j] = maxi;
        return maxi;
    }
    public int maxCoins(int[] nums) {
        int size = nums.length;
        int [] temp = new int[size + 2];
        for(int i = 0; i < size; i++){
            temp[i + 1] = nums[i];
        }
        temp[0] = 1;
        temp[size + 1] = 1;
        int [][] dp = new int[size + 2][size + 2];
        for(int i = 0; i < size + 2; i++){
            for(int j = 0; j < size + 2; j++){
                dp[i][j] = -1;
            }
        }
        int answer = getMax(1, size, temp, dp);
        return answer;
    }
}