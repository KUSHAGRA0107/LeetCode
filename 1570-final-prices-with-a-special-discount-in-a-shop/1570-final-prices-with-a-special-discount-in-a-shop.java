class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int size = prices.length;
        int [] answer = new int[size];
        for(int i = 0;i < size;i++){
            answer[i] = prices[i];
        }

        for(int i = 0;i<size;i++){
            while(!stack.empty() && prices[stack.peek()] >= prices[i]){
                answer[stack.peek()] = prices[stack.peek()] - prices[i];
                stack.pop();
            }
            stack.push(i);
        }
        return answer;
    }

}