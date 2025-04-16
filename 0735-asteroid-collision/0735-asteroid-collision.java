class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int size = asteroids.length;
        for(int i = 0; i < size; i++){
            if(stack.empty() || asteroids[i] > 0) stack.push(asteroids[i]);
            else{
                /*
                Now Only case to be handled is the positive in stack top and negative
                element, while magnitude of element is greater than stack top we pop
                 */
                while(!stack.empty() && stack.peek() >= 0 && stack.peek() < Math.abs(asteroids[i])){
                    stack.pop();
                }

                /*
                There exist special case where 8, -8 same magnitude when we need to pop 
                value from stack
                 */

                if(stack.size() > 0 && stack.peek() > 0 && stack.peek() == Math.abs(asteroids[i])) stack.pop();
                /*
                if any negative element is left then only element can be pushed in stack
                 */
                else if(stack.empty() || stack.peek() < 0) stack.push(asteroids[i]);
            }
        }
        /*
        All the element left in the stack would be the one that are left in space
        capture them in reverse order
         */
        int resultSize = stack.size();
        int [] result = new int[resultSize];
        int index = resultSize - 1;
        while(!stack.empty()){
            result[index] = stack.pop();
            index--;
        }
        return result;
    }
}