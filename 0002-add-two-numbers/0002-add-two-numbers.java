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
    public void add(ListNode l1, ListNode l2, ListNode ptr, int carry){
        if(l1 == null && l2 == null && carry == 0) return;
        int value = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
        int sum = value % 10;
        carry = value / 10;
        ListNode node = new ListNode(sum);
        ptr.next = node;
        ptr = ptr.next;
        add(l1 == null ? null : l1.next,l2 == null ? null : l2.next,ptr, carry);
        return;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode ptr = head;
        add(l1, l2, ptr, 0);
        return ptr.next;
    }
}