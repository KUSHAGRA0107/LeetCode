class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int size = nums.length;
        for(int i = 0; i < size; i++){
            int index = nums[i] - 1;
            while(nums[index] != nums[i]){
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                index = nums[i] - 1;
            }
        }
        for(int i = 0; i < size; i++){
            if(nums[i] != i + 1){
                result.add(i + 1);
            }
        }
        return result;
    }
}