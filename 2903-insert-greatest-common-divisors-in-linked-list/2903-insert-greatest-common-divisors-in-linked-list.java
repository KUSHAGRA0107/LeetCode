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
    public int getGcd(int a, int b){
        while(a > 0 && b > 0){
            if(a > b){
                a = a % b;
            }else{
                b = b % a;
            }
        }
        if(a == 0) return b;
        return a;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode temp = head;
        while(temp.next!= null){
            int gcd = getGcd(temp.val, temp.next.val);
            ListNode node = new ListNode(gcd);
            ListNode nextPtr = temp.next;
            node.next = nextPtr;
            temp.next = node;
            temp = nextPtr;
        }
        return head;
    }
}