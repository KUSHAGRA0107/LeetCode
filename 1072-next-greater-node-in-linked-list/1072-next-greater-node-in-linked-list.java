class Solution {
    public int[] nextLargerNodes(ListNode head) {
        /*
            1. Reverse The linkedlist
            2. Now Find NGE Using Stack
        */
        ListNode curr = head;
        ListNode prev = null;
        ListNode nextNode = null;
        int size = 0;
        while(curr != null){
            size++;
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        head = prev;
        Stack<Integer> stack = new Stack<>();
        int [] answer = new int[size];
        int index = size - 1;
        ListNode temp = head;
        while(temp != null){
            while(!stack.empty() && temp.val >= stack.peek()) stack.pop();
            if(!stack.empty()) answer[index] = stack.peek();
            stack.push(temp.val);
            temp = temp.next;
            index--;
        }
        return answer;
    }
}