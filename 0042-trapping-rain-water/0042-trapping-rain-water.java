class Solution {
    public int trap(int[] height) {
        int size = height.length;
        int [] prefix = new int[size];
        int [] suffix = new int[size];
        int answer = 0;
        prefix[0] = height[0];
        suffix[size - 1] = height[size - 1];
        for(int i = 1;i<size;i++) prefix[i] = Math.max(prefix[i - 1], height[i]);
        for(int i = size - 2;i >= 0;i--) suffix[i] = Math.max(suffix[i + 1], height[i]);
        for(int i = 1; i < size - 1; i++)answer += Math.min(prefix[i], suffix[i]) - height[i];
        return answer;
    }
}