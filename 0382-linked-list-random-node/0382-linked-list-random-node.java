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
import java.util.Random;
class Solution {
    ListNode head;
    public Solution(ListNode head) {
        this.head = head;
    }
    
    public int getRandom() {
        int size = getSize();
        Random random = new Random();
        int value = random.nextInt(size);
        ListNode temp = head;
        int currNode = 0;
        while(temp != null && currNode != value){
            currNode++;
            temp = temp.next;
        }
        return temp.val;
    }
    public int getSize(){
        int size = 0;
        ListNode temp = head;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        return size;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */