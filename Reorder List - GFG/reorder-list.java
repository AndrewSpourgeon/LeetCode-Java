//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

  public class ReorderList {
    Node head; // head of lisl
    Node last; // last of linked list

    /* Linked list Node*/

    /* Utility functions */

    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node) {

        if (head == null) {
            head = node;
            last = head;
        } else {
            // Node temp = head;
            // while (temp.next != null) temp = temp.next;

            last.next = node;
            last = last.next;
        }
    }
    /* Function to print linked list */
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Drier program to test above functions */
    public static void main(String args[]) {

        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            ReorderList llist = new ReorderList();

            int a1 = sc.nextInt();
            Node head = new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }

            llist.head = new Solution().reorderlist(llist.head);

            llist.printList();

            t--;
        }
    }
}
// } Driver Code Ends


/* Following is the Linked list node structure */

/*class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}*/

class Solution {
    Node reorderlist(Node head) {
        // Your code here
        if(head == null || head.next == null || head.next.next == null){
          return head;  
        } 
        //first find the middle node
        Node slow = head , fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        Node mid = slow.next;
        //reverse 2nd half of linked list
        Node prev = null;
        Node cur = mid;
        Node nxt = mid.next;
        while(cur != null){
            
            cur.next = prev;
            prev = cur;
            cur = nxt;
            if(nxt != null){
              nxt = nxt.next;  
            }
        }
        slow.next = null;
        //now connect both linkedlists
        Node start1 = head;
        Node start2 = prev;
        // System.out.println(start1.data);
         //System.out.println(start2.data);
        //1->7
        //4->3
        while(start2 != null){
           Node temp1 = start1.next;
           start1.next = start2;
           start1 = temp1;
           Node temp2 = start2.next;
           start2.next = temp1;
           start2 = temp2;
        }
       return head; 
    }
}
