//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException {
		BufferedReader read =
		new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(read.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(read.readLine());
			String S[] = read.readLine().split(" ");
			int[] arr = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(S[i]);
			int k = Integer.parseInt(read.readLine());

			Solution ob = new Solution();
			System.out.println(ob.countPairs(n, arr, k));
		}
	}
}
// } Driver Code Ends


//User function Template for Java
// 10
// 5 5 10 10 2 1 7 8 9 5
// 3
class Solution {
	static long countPairs(int n, int[] arr, int k) {
		// code here
		int[] ans = new int[k];
		for(int val : arr){
		    int rem = val % k;
		    ans[rem]++;
		}
		long res = 0;
		for(int val : ans){
		    if(val == 1) continue;
		    if(val == 2) {
		        res += 1;
		        continue;
		    }
		    if(val > 2){
		        res += (val)*(val-1)/2;
		    }
		    
		}
		return res;
	}
}