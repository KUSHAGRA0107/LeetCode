class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int [] table = new int[nums.length];
        Arrays.fill(table,1);
        int size = nums.length;
        int [] hash = new int[size];
        for(int i = 1; i < size; i++){
            hash[i] = i;
            for(int prev = 0; prev < i; prev++){
                if(nums[i] % nums[prev] == 0){
                    if(table[prev] + 1 > table[i]){
                        table[i] = table[prev] + 1;
                        hash[i] = prev;
                    }
            }}
        }
        int lastIndex = -1;
        int max= Integer.MIN_VALUE;
        for(int i = 0; i < size; i++){
            if(table[i] > max){
                max = table[i];
                lastIndex = i;
            }
        }
        List<Integer> answer = new ArrayList<>();
        answer.add(nums[lastIndex]);
        while(hash[lastIndex] != lastIndex){
            lastIndex = hash[lastIndex];
            answer.add(nums[lastIndex]);
        }
        return answer;
    }
}