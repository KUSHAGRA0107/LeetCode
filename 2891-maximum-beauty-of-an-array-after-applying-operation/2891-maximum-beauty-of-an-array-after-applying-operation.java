class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int max = -1;
        int index = 0;
        int element, low, mid, high, range = 2 * k;
        for(int i = 0;i < nums.length;i++){
            element = nums[i];
            low = i + 1;
            high = nums.length - 1;

            while(low <= high){
                mid = low + high >> 1;
                if(nums[mid] - element > range){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                    index = mid;
                }
            }
            max = Math.max(max, index - i + 1);
        }
        return max;
    }
}