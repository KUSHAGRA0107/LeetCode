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

/*
    We need to find three value such that nums[i] < nums[j] and nums[i] < nums[k]
    but at the same time nums[i] < nums[k] for any i < j < k
    this gives us an intuition
    that we need to minimize the value of nums[i]
    for any index k we will find it's previous greater element and
    any minimum value from i = 0 to i < j such that it should be minimum till that index
    and also should not be equal to nums[j] and at the same time should be less than
    that of nums[k]

    minimum can be found with help of minimum prefix array
    and we need to check if we find any element smaller than top of stack
    which is greater than the current element and at the same time it should be
    smaller than both nums[i], nums[j]
 */