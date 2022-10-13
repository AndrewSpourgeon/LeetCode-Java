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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 1) return head;
        ListNode counter = head ;
        int count = 0 ;
        while(counter != null){
            count = count + 1;
            counter = counter.next;
        }
        
        ListNode cur = head , nxt = cur.next;
        ListNode dummy = new ListNode(0,head);
        ListNode pre = dummy;
        while(count >=  k){
            for(int i=1 ; i<k ;i++){
                cur.next = nxt.next;
                nxt.next = pre.next;
                pre.next = nxt;
                nxt = cur.next;
            }
            count = count - k;
            pre = cur;
            
            cur = cur.next;
            if(cur != null)
            {
                nxt = cur.next;  
            }
        }
        
        return dummy.next;
    }
}