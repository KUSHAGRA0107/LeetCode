class Solution {
    public int maxArea(int[] height) {
        int size = height.length;
        int i = 0;
        int j = size - 1;
        int answer = 0;
        int maximum = -1;
        while(i < j){
            if(height[i] < height[j]){
                answer = height[i] * (j - i);
                i++;
            }else{
                answer = height[j] * (j - i);
                j--;
            }
            maximum = Math.max(maximum, answer);
        }
        return maximum;
    }
}