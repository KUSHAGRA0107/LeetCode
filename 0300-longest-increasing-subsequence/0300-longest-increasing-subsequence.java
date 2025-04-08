class Solution {
    public int lengthOfLIS(int[] nums) {
        int size = nums.length;
        int [] dp = new int[size];
        Arrays.fill(dp, 1);
        for(int index = 1; index < size; index++){
            for(int prev = 0; prev < index; prev++){
                if(nums[prev] < nums[index]){
                    dp[index] = Math.max(dp[index], dp[prev] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}