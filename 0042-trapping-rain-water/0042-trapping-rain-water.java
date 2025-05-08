class Solution {
    public int trap(int[] height) {
        int answer = 0;
        int size = height.length;
        int [] left = new int[size];
        left[0] = height[0];
        
        int [] right = new int[size];
        right[size - 1] = height[size - 1];

        for(int i = 1; i < size; i++){
            left[i] = Math.max(left[i - 1], height[i]);
        }
        for(int i = size  - 2; i >= 0; i--){
            right[i] = Math.max(right[i + 1], height[i]);   
        }

        for(int i = 0; i < size; i++){
            answer += Math.min(right[i], left[i]) - height[i];
        }
        return answer;
    }
}