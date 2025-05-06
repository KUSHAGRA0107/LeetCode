class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while(low <= high){
            mid = (low + high) >> 1;
            if(nums[low] <= nums[high]) return nums[low];
            if(nums[mid] >= nums[low]){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return nums[low];
    }
}