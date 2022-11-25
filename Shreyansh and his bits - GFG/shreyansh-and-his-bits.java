//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            long  N = Long.parseLong(input_line[0]);
            Solution ob = new Solution();
            System.out.println(ob.count(N));
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution{
    
    long count(long n)
    {
        // Code Here
        long ans = 0;
        String bin = Long.toBinaryString(n);
        int index = 0;
        int c = 0;
        for(int i = bin.length() - 1 ; i >= 0 ; i--){
            index = index + 1;
            if(bin.charAt(i) == '1'){
                c = c + 1;
                if(index != c){
                    ans = ans + ncr(index-1 , c);
                }
            }
        }
        return ans;
    }
    
     long ncr(int n , int r){
        long combo = 1;
        for(int i = 1 ; i <= r ; i++){
            combo = combo * (n-i+1)/i;
        }
        return combo;
    }
}