class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        int size = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < size; i++) set.add(nums[i]);
        int distinct = set.size();
        int i = 0, j = 0;

        while(j < size){
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while(map.size() == distinct){
                answer += size - j;
                map.put(nums[i], map.get(nums[i]) - 1);
                if(map.get(nums[i]) == 0){
                    map.remove(nums[i]);
                }
                i++;
            }
            j++;
        }
        return answer;

    }
}