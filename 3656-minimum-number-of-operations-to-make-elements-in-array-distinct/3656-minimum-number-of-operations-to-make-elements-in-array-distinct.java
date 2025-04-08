class Solution {
    public boolean isDistinct(int [] nums, int start){
        HashSet<Integer> set = new HashSet<>();
        int size = nums.length;
        for(int i = start; i < size; i++){
            if(set.contains(nums[i])) return false;
            set.add(nums[i]);
        }return true;
    }

    public int minimumOperations(int[] nums) {
        int answer = 0, size = nums.length;
        for(int i = 0; i < size; i += 3, answer++){
            if(isDistinct(nums, i)) return answer;
        }return answer;
    }
}