class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        int size = nums.length;
        for(int i = 0; i < size; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for(int i = 0; i < size; i++){
            if(map.containsKey(nums[i])){
                int element = nums[i];
                map.put(element, map.get(element) - 1);
                if(map.get(element) == 0){
                    map.remove(element);
                }
                
                int counter = 1;
                int nextElement = element + 1;
                while(counter != k && map.containsKey(nextElement)){
                    map.put(nextElement, map.get(nextElement) - 1);
                    if(map.get(nextElement) == 0){
                        map.remove(nextElement);
                    }
                    nextElement++;
                    counter++;
                }
                if(counter != k) return false;
        }}
        return true;
    }
}