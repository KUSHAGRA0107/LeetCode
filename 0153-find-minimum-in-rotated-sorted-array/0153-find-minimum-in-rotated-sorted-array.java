class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        int size = nums.length;
        if(size == 1) return nums[0];
        if(size == 2){
            if(nums[0] > nums[1]) return nums[1];
            return nums[0];
        }
        while(low < high){
            mid = (low + high) >> 1;
            if(nums[low] < nums[high]) return nums[low];
            else if(mid - 1 >= 0 && nums[mid - 1] > nums[mid] && mid + 1 < size && nums[mid] < nums[mid + 1]){
                return nums[mid];
            }
            else if(nums[mid] >= nums[low]){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return nums[low];
    }
}