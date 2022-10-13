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
        boolean isPal = true;
        if(head.next == null) return isPal;
        
        ListNode slow = head; 
        ListNode fast = head; 
        ListNode cur = head;
    
       while(fast.next != null && fast.next.next != null){
           slow = slow.next;
           fast = fast.next.next;
       }
        
       ListNode pre = slow;
       ListNode temp = slow.next;
       ListNode nxt = temp.next;
       
        
       //reverse right half
       while(nxt !=null){
           temp.next = nxt.next;
           nxt.next = pre.next;
           pre.next = nxt;
           nxt = temp.next;
       }
        
        
       slow = slow.next;
       while(slow != null){
           if(cur.val != slow.val) {
               isPal = false;
           }
           slow = slow.next;
           cur = cur.next;
       }
        
      return isPal;
    }
}