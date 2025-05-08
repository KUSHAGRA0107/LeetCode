class Solution {
    public int trap(int[] height) {
        int answer = 0;
        int size = height.length;
        int left_max = 0;
        int [] right = new int[size];
        right[size - 1] = height[size - 1];

        for(int i = size  - 2; i >= 0; i--){
            right[i] = Math.max(right[i + 1], height[i]);   
        }

        for(int i = 0; i < size; i++){
            left_max = Math.max(left_max, height[i]);
            answer += Math.min(right[i], left_max) - height[i];
        }
        return answer;
    }
}