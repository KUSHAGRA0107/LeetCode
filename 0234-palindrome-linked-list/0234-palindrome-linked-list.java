/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while(temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        ListNode ptr = head;
        while(!stack.empty()){
            ListNode poppedValue = stack.pop();
            int data = poppedValue.val;
            if(data != ptr.val){
                return false;
            }
            ptr = ptr.next;
        }
        return true;
    }
}