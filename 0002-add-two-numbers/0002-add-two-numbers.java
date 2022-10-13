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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode ans = new ListNode();
        ListNode temp = ans;
        while(l1!=null || l2!=null || carry!=0){
            int sum=0;
            if(l1 != null){
                sum = sum + l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum = sum + l2.val;
                l2 = l2.next;
            }
            int flag = sum + carry;
            ListNode n = new ListNode();
            if(flag < 10){
                n.val = flag;
                carry = flag / 10;
            }
            else{
                n.val = flag % 10;
                carry = flag / 10;
            }
            temp.next = n;
            temp = n; 
        }
        return ans.next ;
    }
}