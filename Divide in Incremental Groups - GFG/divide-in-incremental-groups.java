//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int N = Integer.parseInt(br.readLine().trim());
            int K = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            System.out.println(ob.countWaystoDivide(N, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int countWaystoDivide(int N, int K) {
        // Code here
        int[] ans = new int[1];
        solve(N,K,ans,0);
        return ans[0];
    }
    public void solve(int n , int k , int[] ans,int prev){
        if(n == 0 || k == 0) {
            ans[0]++;
            return;
        }
        int min = Math.max(1,prev) , max = n/k;
        if(k==1){
            min=n;max=n;
        }
        for(int i = min ; i <= max ; i++){
            solve(n-i,k-1,ans,i);
        }
    }
}