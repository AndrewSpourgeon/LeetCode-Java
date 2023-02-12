//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}

class Main
{
    public static void main(String args[])throws Exception
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t;
        t=Integer.parseInt(in.readLine());
        while(t-->0){
            int n;
            n=Integer.parseInt(in.readLine());
            Node head,tail;
            String s[]=in.readLine().trim().split(" ");
            int num=Integer.parseInt(s[0]);
            head=new Node(num);
            tail=head;
            for(int i=1;i<n;i++){
                num=Integer.parseInt(s[i]);
                tail.next=new Node(num);
                tail=tail.next;
            }
            Solution ob=new Solution();
            Node temp=ob.primeList(head);
            while(temp!=null){
                out.print(temp.val+" ");
                temp=temp.next;
            }
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
/*
class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}
*/

class Solution
{
    Node primeList(Node head){
        //code here
        Node ans = head;
        while(head != null){
            int val = head.val;
            if(isPrime(val)){
                head = head.next;
            }
            else{
                int left = val-1;
                int right = val+1;
                while(!isPrime(left) && !isPrime(right)){
                    left--;
                    right++;
                }
                
                if(isPrime(left) && isPrime(right)){
                    head.val = left;
                }
                else if(isPrime(left)){
                    head.val = left;
                }
                else{
                    head.val = right;
                }
                head = head.next;
            }
        }
        return ans;
        
    }
    public boolean isPrime(int val){
        if(val == 0 || val == 1) return false;
        for(int i = 2 ; i <= Math.sqrt(val) ; i++){
            if(val%i == 0) return false;
        }
        return true;
    }
}