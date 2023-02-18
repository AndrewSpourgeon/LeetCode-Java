//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            String arr = read.readLine().trim();

            Solution ob = new Solution();
            out.println(ob.appleSequence(N, M, arr));
        }
        out.close();
    }
}


// } Driver Code Ends
//User function Template for Java


class Solution{
    public static int appleSequence(int n, int m, String arr){
        //code here
        int start = 0 , end = 0 , maxLen = 0 , count = 0;
        
        while(end < n){
            
            if(arr.charAt(end) == 'O') count ++;
            
            while(count > m){
                if(arr.charAt(start) == 'O') count--;
                start++;
            }
            
            maxLen = Math.max(maxLen , (end-start)+1);
            
            end++;
        }
        
        return maxLen;
    }
}


//{ Driver Code Starts.

// } Driver Code Ends