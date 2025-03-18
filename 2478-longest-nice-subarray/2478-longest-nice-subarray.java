class Solution {
    public int longestNiceSubarray(int[] nums) {
        int usedBit = 0;
        int start = 0;
        int size = nums.length;
        int maxAnswer = 1;
        for(int end = 0; end < size; end++){
            while((usedBit & nums[end]) != 0){
                usedBit ^= nums[start];
                start++;
            }
            usedBit |= nums[end];
            maxAnswer = Math.max(maxAnswer, end - start + 1);
        }
        return maxAnswer;
    }
}