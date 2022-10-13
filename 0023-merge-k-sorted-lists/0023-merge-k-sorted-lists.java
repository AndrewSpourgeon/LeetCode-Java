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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        ListNode head = new ListNode();
        ListNode temp = head;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(new ListComaparator());
        for(ListNode ln : lists){
            if(ln != null) minHeap.add(ln);
        }
        
        while(minHeap.size() != 0 ){
            ListNode knext = minHeap.peek().next;
            temp.next = minHeap.poll();
            temp = temp.next;
            if(knext != null){
                minHeap.add(knext);
            } 
        }
        return head.next;
    }
}
class ListComaparator implements Comparator<ListNode>{
    @Override
    public int compare(ListNode l1 , ListNode l2){
        if(l1.val > l2.val){
            return 1;
        }
        else{
            return -1;
        }
    }
}