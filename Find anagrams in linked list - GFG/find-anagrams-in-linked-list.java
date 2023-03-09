//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    char data;
    Node next;

    Node(char x) {
        data = x;
        next = null;
    }

    public static Node inputList(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine().trim()); // Length of Linked List

        String[] s = br.readLine().trim().split(" ");
        Node head = new Node((s[0].charAt(0))), tail = head;
        for (int i = 1; i < s.length; i++)
            tail = tail.next = new Node((s[i].charAt(0)));

        return head;
    }

    public static void printList(Node node, PrintWriter out) {
        while (node != null) {
            out.print(node.data + " ");
            node = node.next;
        }
        out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            Node head = Node.inputList(br);

            String S = br.readLine().trim();

            Solution obj = new Solution();
            ArrayList<Node> res = obj.findAnagrams(head, S);

            for (Node node : res) {
                Node temp = node;
                Node.printList(temp, out);
            }
            if (res.size() == 0) {
                out.println("-1");
            }
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
/*

Definition for singly Link List Node
class Node
{
    char data;
    Node next;

    Node(char x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static ArrayList<Node> findAnagrams(Node head, String s) {
        // code here
        ArrayList<Node> ans = new ArrayList<>();
        int n = s.length(),cur = 1;
        Node i = head , j= i;
        StringBuilder sb = new StringBuilder();
        Node last = null,last1 = null;
        while(cur <= n && j != null){
            sb.append(j.data);
            if(cur == n) last = j;
            j = j.next;
            cur++;
        }
        boolean flag = false;
        if(cur > n && isAnag(n,s,sb.toString())){
            sb.delete(0,n);
            last.next = null;
            ans.add(i);
            i = j;
            flag = true;
        }
        else{
            sb.deleteCharAt(0);
            i = i.next;
        }
        //siliding window
        while(j != null){
            if(flag){
                cur = 1;
                flag = false;
                while(cur <= n && j != null){
                    sb.append(j.data);
                    if(cur == n) last = j;
                    j = j.next;
                    cur++;
                }
                if(cur > n && isAnag(n,s,sb.toString())){
                    sb.delete(0,n);
                    last.next = null;
                    ans.add(i);
                    i = j;
                    flag = true;
                }
                else{
                    sb.deleteCharAt(0);
                    i = i.next;
                }
            }
            else{
                if(j!= null){
                   sb.append(j.data);
                   last1 = j;
                   j=j.next;
                }
                if(isAnag(n,s,sb.toString())){
                    sb.delete(0,n);
                    last1.next = null;
                    ans.add(i);
                    i = j;
                    flag = true;
                }
                else{
                    sb.deleteCharAt(0);
                    i = i.next;
                }
            }
        }

        return ans.size() > 0 ? ans : new ArrayList<Node>();
    }
    public static boolean isAnag(int n,String s1 , String s2){
        int[] dp = new int[26];
        for(int i = 0 ; i < n ; i++){
            dp[s1.charAt(i)-'a']++;
            dp[s2.charAt(i)-'a']--;
        }
        for(int val : dp){
            if(val != 0) return false;
        }
        return true;
    }
}