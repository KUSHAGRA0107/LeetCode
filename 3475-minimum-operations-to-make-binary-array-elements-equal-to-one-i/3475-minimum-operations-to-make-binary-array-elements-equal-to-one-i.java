class Solution {
    public int minOperations(int[] nums) {
        int count = 0;
        int size = nums.length;
        int i = 0, j = 0;
        while(j < size){
            if(j - i + 1 == 3){
                if(nums[i] == 0){
                    count++;
                    for(int k = i; k < j + 1; k++){
                        nums[k] = 1 - nums[k];
                    }
                }
                i++;
            }
            j++;
        }
        
        for(int idx = 0; idx < size; idx++){
            if(nums[idx] == 0){
                return -1;
            }
        }
        return count;
    }
}