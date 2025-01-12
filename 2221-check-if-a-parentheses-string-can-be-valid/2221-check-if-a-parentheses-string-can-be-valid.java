class Solution {
    public boolean canBeValid(String s, String locked) {
        int length = s.length();
        if(length % 2 == 1)return false;
        Stack<Integer> stack = new Stack();
        Stack<Integer> unlocked = new Stack();

        for(int i = 0;i < length; i++){
            if(locked.charAt(i) == '0'){
                unlocked.push(i);
            }
            else if(s.charAt(i) == '('){
                stack.push(i);
            }
            else if(s.charAt(i) == ')'){
                if(!stack.empty()){
                    stack.pop();
                }
                else if(!unlocked.empty()){
                    unlocked.pop();
                }
                else{
                    return false;
                }
            }
        }
        while(!stack.empty() && !unlocked.empty() && stack.peek() < unlocked.peek()){
            stack.pop();
            unlocked.pop();
        }
        if(!stack.empty()) return false;
        return true; 
    }
}