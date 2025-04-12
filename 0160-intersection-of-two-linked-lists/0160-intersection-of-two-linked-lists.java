/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public int getSize(ListNode head){
        if(head == null){
            return 0;
        }
        return 1 + getSize(head.next);
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = getSize(headA);
        int sizeB = getSize(headB);
        ListNode temp = null;
        ListNode tempA = headA;
        ListNode tempB = headB;
        int counter = 0;
        if(sizeA > sizeB){
            counter = sizeA - sizeB;
            temp = headA;
            while(temp != null && counter != 0){
                temp = temp.next;
                counter--;
            }
            tempA = temp;
        }else{
            counter = sizeB - sizeA;
            temp = headB;
            while(temp != null && counter != 0){
                temp = temp.next;
                counter--;
            }
            tempB = temp;
        }
        while(tempA != null && tempB != null){
            if(tempA == tempB) return tempA;
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return null;
    }
}