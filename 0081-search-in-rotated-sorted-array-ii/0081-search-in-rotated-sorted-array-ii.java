class Solution {
    public boolean search(int[] nums, int target) {
        int size = nums.length;
        int low = 0;
        int high = size - 1;
        while(low <= high){
            int mid = (low + high) >> 1;
            if(nums[mid] == target) return true;
            if(nums[mid] == nums[low]){
                low++;
                continue;
            }
            if(nums[mid] >= nums[low]){
                if(nums[low] <= target && target < nums[mid]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else{
                if(nums[mid] < target && target <= nums[high]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}