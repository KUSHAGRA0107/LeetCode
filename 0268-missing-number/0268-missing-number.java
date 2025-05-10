class Solution {
    public int missingNumber(int[] nums) {
        int size = nums.length;
        for(int i = 0; i < size; i++){
            int correctPosition = nums[i]; /**3 */
            while(correctPosition < size && nums[i] != nums[correctPosition]){
                int temp = nums[correctPosition];
                nums[correctPosition] = nums[i];
                nums[i] = temp;
                correctPosition = nums[i];
            }
        }

        for(int i = 0; i < size; i++){
            if(nums[i] != i){
                return i;
            }
        }
        return size;
    }
}