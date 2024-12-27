class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int [] prefix = new int[values.length];
        int max = 0;
        prefix[0] = values[0];
        for(int i = 1; i < values.length ;i++){
            prefix[i] = Math.max(prefix[i - 1], values[i] + i);
        }           
        for(int j = 1; j < values.length; j++){
            int curr = values[j] - j; 
            max = Math.max(max, prefix[j - 1] + curr);
        }
        return max;
    }
}