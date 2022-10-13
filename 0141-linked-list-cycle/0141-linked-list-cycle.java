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
    public boolean hasCycle(ListNode head) {
        // List<ListNode> dp = new ArrayList<ListNode>();
        // boolean exists = false;
        // while(head != null){
        //     if(!dp.contains(head.next)){
        //         dp.add(head.next);
        //     }
        //     else{
        //         exists = true;
        //         break;
        //     }
        //     head = head.next;
        // }
        // return exists;
        
        
        if(head == null || head.next == null) return false;
        
        ListNode tortoise = head;
        ListNode hare = head;
        
        while( hare.next != null && hare.next.next !=null){
            hare = hare.next.next;
            tortoise = tortoise.next;
            if(hare == tortoise) return true;
        }
            
        return false;    
            
            
            
            
            
    }
}