class Solution {
    public int unequalTriplets(int[] nums) {
        int answer = 0;
        int size = nums.length;
        for(int i = 0; i < size - 2; i++){
            for(int j = i + 1; j < size - 1; j++){
                for(int k = j + 1; k < size; k++){
                    if(nums[i] != nums[j] && nums[j] != nums[k] && nums[i] != nums[k]) answer++;
                }
            }
        }
        return answer;
    }
}