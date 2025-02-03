class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int increasingCount = 1;
        int decreasingCount = 1;
        int size = nums.length;
        int answer = 0;
        int startElement = 0;

        for(int i = 0; i<size; i++){
            startElement = nums[i];
            increasingCount = 1;
            for(int j = i + 1; j < size; j++){
                if(nums[j] <= startElement){
                    break;
                }
                increasingCount++;
                startElement = nums[j];
            }
            answer = Math.max(answer, increasingCount);
        }

        for(int i = 0; i<size; i++){
            startElement = nums[i];
            decreasingCount = 1;
            for(int j = i + 1; j < size; j++){
                if(nums[j] >= startElement){
                    break;
                }
                decreasingCount++;
                startElement = nums[j];
            }
            answer = Math.max(answer, decreasingCount);
        }
        
        return answer;
    }
}