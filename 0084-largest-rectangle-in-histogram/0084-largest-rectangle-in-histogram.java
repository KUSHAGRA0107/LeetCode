class Solution {
    public int largestRectangleArea(int[] heights) {
        int size = heights.length;
        int [] prevSmaller = new int[size];
        int [] nextSmaller = new int[size];
        Arrays.fill(prevSmaller, -1);
        Arrays.fill(nextSmaller, size);
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> next = new Stack<>();
        for(int i = 0; i < size; i++){
            while(stack.size() != 0 && heights[i] <= heights[stack.peek()]) stack.pop();
            if(stack.size() > 0) prevSmaller[i] = stack.peek();
            stack.push(i); 
        }
        for(int i = size - 1; i >= 0; i--){
            while(next.size() != 0 && heights[i] <= heights[next.peek()]) next.pop();
            if(next.size() > 0) nextSmaller[i] = next.peek();
            next.push(i); 
        }
        for(int i = 0; i < size; i++){
            answer = Math.max(answer, heights[i] * (nextSmaller[i] - prevSmaller[i] - 1));
        }
        return answer;
    }
}