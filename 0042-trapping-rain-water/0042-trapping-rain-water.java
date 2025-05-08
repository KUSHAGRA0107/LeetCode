class Solution {
    public int trap(int[] height) {
        int answer = 0;
        int size = height.length;
        int i = 0;
        int j = size - 1;
        int lmax = height[0];
        int rmax = height[size - 1];

        while(i <= j){
            if(lmax <= rmax){
                lmax = Math.max(lmax, height[i]);
                answer += lmax - height[i];
                i++;
            }else{
                rmax = Math.max(rmax, height[j]);
                answer += rmax - height[j];
                j--;
            }
        }
        return answer;
    }
}