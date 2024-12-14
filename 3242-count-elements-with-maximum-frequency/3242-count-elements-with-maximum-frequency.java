class Solution {
    public int maxFrequencyElements(int[] nums) {

        // initialisation of the variable

        int answer = 0;
        int maximumValue = -1;
        int getMaximum = -1;
        int size = nums.length;

        // get maximum element to get size of frequency array
        for(int i = 0;i < size;i++){
            if(nums[i] > getMaximum){
                getMaximum = nums[i];
            }
        }

        int [] frequency = new int[getMaximum + 1];

        // creation of frequency array
        for(int i = 0; i < size; i++){
            frequency[nums[i]]++;
        }

        // get the maximum frequency that occcured in the array
        for(int i = 0; i < frequency.length;i++){
            if(frequency[i] > maximumValue){
                maximumValue = frequency[i];
            }
        }

        // now all the element having the maximumValue as their frequency 
        // will get their frequency added up
        for(int i = 0; i < frequency.length; i++){
            if(frequency[i] == maximumValue){
                answer += maximumValue;
            }
        }
        return answer;
    }
}