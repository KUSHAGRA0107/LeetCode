class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null || left == right) return head;
        ListNode prev = null;
        ListNode curr = head;
        int i = 1;

        while(curr != null && i != left){
            prev = curr;
            curr = curr.next;
            i++;
        }

        ListNode startNode = prev;
        ListNode startHead = curr;
        prev = null;

        while(curr != null && i != right + 1){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
            i++;
        }
        startHead.next = curr;
        if(startNode != null){
            startNode.next = prev;
        }else{
            return prev;
        }
        return head;
    }
}