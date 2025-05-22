class Solution {
    public int longestArithSeqLength(int[] nums) {
        int maximum = 0;
        int size = nums.length;
        for(int i = 0; i < size; i++){
            for(int j = i + 1; j < size; j++){
                int count = 2;
                int difference = nums[j] - nums[i];
                int lastTerm = nums[j];
                for(int k = j + 1; k < size; k++){
                    if(nums[k] - lastTerm == difference){
                        count++;
                        lastTerm = nums[k];
                    }
                }
                maximum = Math.max(maximum, count);
            }
        }
        return maximum;
    }
}