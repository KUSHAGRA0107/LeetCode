class Solution {
    public long maximumTripletValue(int[] nums) {
        long maxi = 0;
        int size = nums.length;
        for(int i = 0; i < size; i++){
            for(int j = i + 1; j < size; j++){
                for(int k = j + 1; k < size; k++){
                    maxi = Math.max(maxi,(long) (nums[i] - nums[j]) * nums[k]);
                }
            }
        }   
        return maxi;
    }
}