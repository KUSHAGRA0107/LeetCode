class Solution {
    public int firstMissingPositive(int[] nums) {
        int size = nums.length;

        for(int i = 0; i < size; i++){
            int correctPosition = nums[i] - 1;
            while(nums[i] > 0 && nums[i] <= size && nums[i] != nums[correctPosition]){
                int temp = nums[correctPosition];
                nums[correctPosition] = nums[i];
                nums[i] = temp;
                correctPosition = Math.abs(nums[i]) - 1;
            }
        }

        for(int i = 0; i < size; i++){
            if(nums[i] != i + 1) 
            {
                return i + 1;
        }}

        return size + 1;
    }
}