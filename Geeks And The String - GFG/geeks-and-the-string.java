//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String s; 
            s = br.readLine();
            
            Solution obj = new Solution();
            String res = obj.removePair(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String removePair(String s) {
        // code here
        Deque<Character> queue = new ArrayDeque<Character>();
        int n = s.length();
        for(int i = 0 ; i < n ; i++){
            char c = s.charAt(i);
            if(queue.isEmpty() || queue.peekLast() != c){
                queue.addLast(c);
            }
            else if(queue.peekLast() == c){
                queue.pollLast();
            }
        }
        
        String ans = "";
        boolean flag = false;
        for(char c : queue){
            ans += c;
            flag = true;
        }
        return flag ? ans : "-1";
    }
}
        
