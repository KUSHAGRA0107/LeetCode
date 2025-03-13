class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 1;
        int size = nums.length;
        for(int i = 2; i < size; i++){
            if(nums[j - 1] != nums[i]){
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }
}