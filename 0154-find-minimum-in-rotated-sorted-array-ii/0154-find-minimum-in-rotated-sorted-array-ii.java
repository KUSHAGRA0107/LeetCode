class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while(low < high){
            int mid = (low + high) >> 1;
            if(nums[low] < nums[high]) return nums[low];
            if(nums[low] == nums[mid]){
                low++;
                continue;
            }
            if(nums[mid] > nums[low]){
                low = mid;
            }else{
                high = mid;
            }
        } 
        return nums[low];
    }
}