class Pair{
    int value;
    int index;
    Pair(int value, int index){
        this.value = value;
        this.index = index;     
    }
}
class StockSpanner {
    Stack<Pair> stack;
    int span;
    public StockSpanner() {
        stack = new Stack<>();
        span = 0;
    }

    public int next(int price) {
        int answer = span;
        while(!stack.empty() && price >= stack.peek().value){
            stack.pop();
        }
        if(!stack.empty()){
            answer = span - stack.peek().index;
        }
        span++;
        stack.push(new Pair(price, span));
        return answer + 1;
    }
}