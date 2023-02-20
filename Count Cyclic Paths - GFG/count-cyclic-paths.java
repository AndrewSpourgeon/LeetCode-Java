//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
	public static int countPaths(int N){
		//code here
		if(N==1) return 0;
		long mod = 1000000000 + 7;
		long p1 = 0;
		long p2 = 1;
		for(int i = 2 ; i < N ; i++){
		    long temp = p2;
		    p2 = (2*p2 + 3*p1) % mod;
		    p1 = temp;
		}
		return (int) ((3*p2) % mod);
	}
}

//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.countPaths(N));
        }
    }
}

// } Driver Code Ends