class Solution {
    public int[] nextGreaterElements(int[] nums) {
    /*
        Instead of traversing on modified Array,
        it is suggested to use modulus operation
        starting from 2n - 1 to 0 and every index
        must be recognized by i % n

     */
        int size = nums.length;
        ArrayList<Integer> answer = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int [] result = new int[size];
        Arrays.fill(result, -1);
        for(int i = 2 * size - 1; i >= 0 ; i--){
            while(!stack.empty() && stack.peek() <= nums[i % size])stack.pop();
            if(!stack.empty()) result[i % size] = stack.peek();
            stack.push(nums[i % size]);
        }
        return result;
    }
}