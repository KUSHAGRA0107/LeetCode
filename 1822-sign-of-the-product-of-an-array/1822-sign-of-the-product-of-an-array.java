class Solution {
    public int arraySign(int[] nums) {
        int countNegative = 0, zero = 0;
        int size = nums.length;
        for(int i = 0; i < size; i++){
            if(nums[i] < 0) countNegative++;
            if(nums[i] == 0) zero++;
        }
        if(zero >= 1) return 0;
        return countNegative % 2 == 0 ? 1 : -1;
    }
}