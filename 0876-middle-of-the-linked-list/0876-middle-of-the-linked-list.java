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
    public ListNode middleNode(ListNode head) {
        ListNode ans = new ListNode();
        int count=0;
        ListNode temp = head;
        while(head!=null){
            count+=1;
            head = head.next;
        }
        int mid = ( count/2 ) + 1;
        int flag = count;
        while(temp!=null){
            count-=1;
            if(count+1==mid && flag%2==1){
              ans = temp;
                break;
            }
            else if(count+1==mid && flag%2==0){
                ans = temp.next;
                break;
            }
            temp = temp.next;
        }
        
        
        return ans;
    }
    
}