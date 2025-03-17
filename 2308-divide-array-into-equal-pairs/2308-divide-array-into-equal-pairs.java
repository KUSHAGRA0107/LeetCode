class Solution {
    public boolean divideArray(int[] nums) {
        int [] frequency = new int[Arrays.stream(nums).max().getAsInt() + 1];
        for(int i : nums){
            frequency[i] += 1;
        }
        for(int i : frequency){
            if(i % 2 != 0) return false;
        }
        return true;
    }
}