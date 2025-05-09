class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int size = nums.length;
        for(int i = 0; i < size; i++){
            int currIdx = Math.abs(nums[i]) - 1;
            if(nums[currIdx] > 0){
                nums[currIdx] = -1 * nums[currIdx];
            }else{
                list.add(currIdx + 1);
            }
        }
        return list;
    }
}