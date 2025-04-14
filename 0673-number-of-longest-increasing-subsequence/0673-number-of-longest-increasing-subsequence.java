class Solution {
    public int findNumberOfLIS(int[] nums) {
        int size = nums.length;
        int [] table = new int[size];
        int [] counter = new int[size];
        Arrays.fill(table, 1);
        Arrays.fill(counter, 1);

        for(int i = 1; i < size; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    if(table[j] + 1 == table[i]){
                        counter[i] = counter[j] + counter[i];
                    }else if(table[j] + 1 > table[i]){
                        table[i] = table[j] + 1;
                        counter[i] = counter[j];
                    }
                }
            }
        }
        int max = Arrays.stream(table).max().getAsInt();
        int answer = 0;
        for(int i = 0; i < size; i++){
            if(max == table[i]){
                answer += counter[i];
            }
        }
        return answer;
    }
}