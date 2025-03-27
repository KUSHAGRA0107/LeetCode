class Solution {
    public int getSize(ListNode head){
        int size = 0;
        while(head != null){
            size++;
            head = head.next;
        }
        return size;
    }
    public ListNode middleNode(ListNode head) {
        int size = getSize(head);
        int nodeTobeSearched = (size / 2) + 1;
        int currNode = 1;
        ListNode temp = head;
        while(temp != null && currNode != nodeTobeSearched){
            temp = temp.next;
            currNode++;
        }
        // if(size % 2 == 0){
        //     return temp.next;
        // }
        return temp;
    }
}