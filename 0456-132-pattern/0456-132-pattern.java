class Pair{
    int value;
    int index;
    Pair(int value, int index){
        this.value = value;
        this.index = index;
    }
}

class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Pair> stack = new Stack<>();
        int size = nums.length;
        int [] min = new int[size];
        min[0] = nums[0];
        for(int i = 1; i < size; i++){
            min[i] = Math.min(min[i - 1], nums[i]);
        }
        for(int i = 0; i < size; i++){
            if(nums[i] > min[i]){
                while(!stack.empty() && stack.peek().value <= nums[i]) stack.pop();
                if(!stack.empty() && min[stack.peek().index] < nums[i]) return true;
                stack.push(new Pair(nums[i], i));
            }
        }return false;
    }
}