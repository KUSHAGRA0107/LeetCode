class Solution {
    public int sumOfSquares(int[] nums) {
        int answer = 0;
        int size = nums.length;
        for(int i = 0; i < size; i++){
            if(size % (i+1) == 0){
                answer += nums[i] * nums[i];
            }
        }
        return answer;
    }
}