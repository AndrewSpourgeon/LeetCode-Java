/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode cycle = null;
        boolean isPres = false;
        ListNode slow = head , fast = head;
        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                isPres = true;
                break;
            }
        }
        fast = head;
        while(slow != fast && isPres){
            slow = slow.next;
            fast = fast.next;
        }
        if(isPres){
            cycle = slow;
        }
        return cycle;
    }
}