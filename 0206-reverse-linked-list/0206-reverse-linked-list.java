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
    boolean isFirst=true;
    ListNode head1 = new ListNode();
    ListNode ans;
    public ListNode reverseList(ListNode head) {
        while(head != null){
            
        ans = new ListNode();
        ans.val = head.val;
        if(isFirst){
            ans.next=null;
            isFirst=false;
        }
        else{
            ans.next=head1;
        }
        head1 = ans;
        head=head.next;
            }
        return ans;
    }
    
}