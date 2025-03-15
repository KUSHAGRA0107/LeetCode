class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int answer = 1;
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i - 1]){
                count++;
            }else{
                count = 1;
            }
            answer = Math.max(answer, count);
            }
        return answer;
    }
}