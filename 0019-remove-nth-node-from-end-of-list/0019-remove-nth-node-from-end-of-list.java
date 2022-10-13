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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ref = head;
        ListNode ans = head;
        int count =0;
        
        while(head != null){
            count += 1;
            head = head.next; 
        }
        if(count==1){
            return null;
        }
        if(count ==n){
            ans = ref.next;
            return ans;
        }
        else{
        while(ref !=null){
            
            count -= 1;
            if(count == n){
               if(ref.next.next == null){
                    ref.next = null;
                    break;
                }
                
                else{
                  ListNode temp = ref.next.next;
                    ref.next.next = null;
                    ref.next = temp;
                break;
                }
            }
            ref = ref.next;
        }
        }
        return ans;
    }
}