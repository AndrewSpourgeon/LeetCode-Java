//{ Driver Code Starts
import java.io.*;
import java.util.*;


class Node
{
    int data;
    Node next;

    Node(int x)
    {
        data = x;
        next = null;
    }

    public static Node inputList(BufferedReader br) throws IOException
    {
        int n = Integer.parseInt(br.readLine().trim()); // Length of Linked List

        String[] s = br.readLine().trim().split(" ");
        Node head = new Node(Integer.parseInt(s[0])), tail = head;
        for(int i = 1; i < s.length; i++)
            tail = tail.next = new Node(Integer.parseInt(s[i]));

        return head;
    }

    public static void printList(Node node)
    {
        while (node != null)
        {
    		System.out.print(node.data + " ");
    		node = node.next;
    	}
    	System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            Node head = Node.inputList(br);
            
            
            int k;
            k = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            Node res = obj.reverse(head, k);
            
            Node.printList(res);
            
        }
    }
}

// } Driver Code Ends


/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static Node reverse(Node head, int k) {
        // code here
        Node second = null;
        Node first = head;
        //breaking into parts
        while(head != null){
            k--;
            if(k==0){
                second = head.next;
                head.next = null;
                break;
            }
            head = head.next;
        }
        
        //reverse first
        Node prev1 = null;
        Node cur1 = first;
        while(cur1 != null){
            Node next = cur1.next;
            cur1.next = prev1;
            prev1 = cur1;
            cur1 = next;
        }
        
        //reverse second
        Node prev2 = null;
        Node cur2 = second;
        while(cur2 != null){
            Node next = cur2.next;
            cur2.next = prev2;
            prev2 = cur2;
            cur2 = next;
        }
        
        //connect both;
        
        first.next = prev2;
        return prev1;
    }
}
        
