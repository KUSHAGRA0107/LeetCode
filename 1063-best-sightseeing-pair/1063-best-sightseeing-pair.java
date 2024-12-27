class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int max = 0;
        int prev = values[0] + 0;
        int curr = 0;
        for(int i = 1; i < values.length; i++){
            max = Math.max(max, values[i] - i + prev);
            prev = Math.max(prev, values[i] + i);
        }
        return max;
    }
}