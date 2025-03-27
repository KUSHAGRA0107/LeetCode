class Solution {
    public ListNode deleteMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode ptr = head;
        if(head == null || head.next == null){
            return null;
        }
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        while(ptr.next != slow){
            ptr = ptr.next;
        }
        ptr.next = slow.next;
        slow.next = null;
        return head;
    }
}