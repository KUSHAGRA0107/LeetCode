class Solution {
    public int sumSubarrayMins(int[] arr) {
        /*
        Find Next lesser index for every element
        Find Previous lesser index for every element
        for every index answer += (left_max - i * right_max - i * arr[i]) % mod;
        */
        int size = arr.length;

        int mod = (int) 1e9 + 7;
        long answer = 0;
        int [] prevMin = new int[size];
        int [] nextMin = new int[size];

        Arrays.fill(prevMin, -1);
        Arrays.fill(nextMin, size);

        Stack<Integer> stack = new Stack<>();
        for(int i = size - 1; i >= 0; i--){
            while(!stack.empty() && arr[stack.peek()] > arr[i]) stack.pop();
            if(!stack.empty()) nextMin[i] = stack.peek();
            stack.push(i);
        }
        stack.clear();

        for(int i = 0; i < size; i++){
            while(!stack.empty() && arr[stack.peek()] >= arr[i]) stack.pop();
            if(!stack.empty()) prevMin[i] = stack.peek();
            stack.push(i);
        }   

        for(int i = 0; i < size; i++){
            answer += (long) (i - prevMin[i]) * (nextMin[i] - i) % mod * arr[i] % mod;
            answer %= mod;
        }
        return (int) answer;
    }
}