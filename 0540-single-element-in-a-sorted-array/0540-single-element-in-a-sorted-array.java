class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        int size = nums.length;
        if(size == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[size - 1] != nums[size - 2]) return nums[size - 1];
        while(low <= high){
            mid = low + (high - low)/2;
            if(nums[mid - 1] != nums[mid] && nums[mid] != nums[mid + 1]){
                return nums[mid];
            }
            else if((mid % 2 == 0 && nums[mid] == nums[mid + 1]) ||
            (mid % 2 == 1 && nums[mid] == nums[mid - 1])){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
}