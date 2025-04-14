class Solution {
    public int getIndex(List<Integer> temp, int target){
        int low = 0;
        int high = temp.size() - 1;
        int index = -1;
        while(low <= high){
            int mid = (low + high) >> 1;
            if(temp.get(mid) >= target){
                index = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return index;
    }
    public int lengthOfLIS(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        int length = 0;
        int size = nums.length;
        for(int i = 0; i < size; i++){
            if(temp.size() == 0 || temp.get(temp.size() - 1) < nums[i]){
                temp.add(nums[i]);
                length++;
            }else{
                int getIdx = getIndex(temp, nums[i]);
                if(getIdx != -1)temp.set(getIdx, nums[i]);
            }
        }
        return length;
    }
}