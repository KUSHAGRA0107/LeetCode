class Solution {
    public int trap(int[] height) {
        /* Why Lmax < Rmax holds true ??
            1. 
         */
        int size = height.length;
        int left = 0;
        int right = size - 1;
        int left_max = height[left];
        int right_max = height[right];
        int answer = 0;
        while(left <= right){
            if(left_max < right_max){
                left_max = Math.max(left_max, height[left]);
                answer += left_max - height[left];
                left++;
            }else{
                right_max = Math.max(right_max, height[right]);
                answer += right_max - height[right];
                right--;
            }
        }
        return answer;

    }
}