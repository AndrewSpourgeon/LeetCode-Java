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
    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null || head.next == null) return head;
        int num = 0;
        ListNode count = head;
        while(count != null){
            num = num + 1;
            if(count.next == null)
            {
                count.next = head;
                count = head;
                break;
            }
            count = count.next;
        }
        if(k >= num) k = k % num;
        int index = 0;
        while(count != null){
            index = index + 1;
            if(index == num-k) {
                head = count.next;
                count.next = null;
            }
            count = count.next;
        }
        return head;
    }
}