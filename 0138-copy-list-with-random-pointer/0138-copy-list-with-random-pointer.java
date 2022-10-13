/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
       if(head == null) return null;
       Node cur = head;
        
       //step 1 -> create copies and connect 
       while(cur != null){
           Node n = new Node(cur.val);
           Node temp = cur.next;
           cur.next = n;
           n.next = temp;
           cur = temp;
       }
        
       //step 2 -> change randoms in copies
       cur = head;
       while(cur != null){
           cur.next.random = cur.random == null ? null : cur.random.next;
           cur = cur.next.next;
       }
        
     //step 3 -> remove connections b/w old and new lists  by changing next pointers
        Node front = head;
        Node back = head.next.next;
        Node dummy = new Node(0);
        dummy.next = head.next;
        Node ans = dummy;
        while(back != null){
            front.next = back;
            dummy.next.next = back.next;
            dummy = dummy.next;
            front = front.next;
            back = back.next.next;
        }
        front.next = null;
        dummy.next.next = null;
        return ans.next;
    }
}