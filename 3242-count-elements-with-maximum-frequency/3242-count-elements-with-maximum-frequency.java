class Solution {
    public int maxFrequencyElements(int[] nums) {
        int answer = 0;
        int maximumValue = -1;
        int getMaximum = -1;
        int size = nums.length;

        for(int i = 0;i < size;i++){
            if(nums[i] > getMaximum){
                getMaximum = nums[i];
            }
        }

        int [] frequency = new int[getMaximum + 1];

        for(int i = 0; i < size; i++){
            frequency[nums[i]]++;
        }

        for(int i = 0; i < frequency.length;i++){
            if(frequency[i] > maximumValue){
                maximumValue = frequency[i];
            }
        }

        for(int i = 0; i < frequency.length; i++){
            if(frequency[i] == maximumValue){
                answer += maximumValue;
            }
        }
        return answer;
    }
}