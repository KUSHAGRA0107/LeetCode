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
    public void helper(ListNode head1, ListNode head2, ListNode ptr, int carry)
    {
        if(head1 == null && head2 == null && carry == 0) return;
        int head1_val = (head1 == null) ? 0 :  head1.val;
        int head2_val = (head2 == null) ? 0 :  head2.val;
        int summation = head1_val + head2_val + carry;
        int sum = summation % 10;
        carry = summation / 10;
        ListNode node = new ListNode(sum);
        ptr.next = node;
        ptr = node;
        helper(head1 == null ? null : head1.next, head2 == null ? null : head2.next, ptr, carry);
        return;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode ptr = head;
        int carry = 0;
        helper(l1, l2, ptr, carry);
        return head.next;
    }
}