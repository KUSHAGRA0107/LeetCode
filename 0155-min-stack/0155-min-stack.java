class Pair{
    int value;
    int current_min;
    Pair(int val, int min){
        value = val;
        current_min = min;
    }
}
class MinStack {
    Stack<Pair> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.empty()){
            Pair pair = new Pair(val,val);
            stack.push(pair);
        }else{
            Pair top_pair = stack.peek();
            int min = top_pair.current_min;
            if(val < min){
                min = val;
            }
            Pair pair = new Pair(val, min);
            stack.push(pair);
        }
    }
    
    public void pop() {
        if(!stack.empty()) stack.pop();
    }
    
    public int top() {
        if(!stack.empty()) return stack.peek().value;
        return -1;
    }
    
    public int getMin() {
        if(!stack.empty()) return stack.peek().current_min;
        return -1;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */