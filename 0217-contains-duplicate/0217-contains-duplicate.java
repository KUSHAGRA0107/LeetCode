class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            int element = nums[i];
            if(set.contains(element) == true){
                return true;
            }
            set.add(element);
        }
        return false;
    }
}
