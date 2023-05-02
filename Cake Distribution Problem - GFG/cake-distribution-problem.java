//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String [] str = br.readLine().trim().split(" ");
			int n = Integer.parseInt(str[0]);
			int k = Integer.parseInt(str[1]);
			int [] sweetness = new int[n];
			str = br.readLine().trim().split(" ");
			int i = 0;
			for(String s: str) {
				sweetness[i++] = Integer.parseInt(s);
			}
			Solution obj = new Solution();
			System.out.println(obj.maxSweetness(sweetness, n, k));
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
	int maxSweetness(int[] sweetness, int N, int K) {
	    // Write your code here.
	    long low = Arrays.stream(sweetness).min().getAsInt();
	    long high = Arrays.stream(sweetness).sum();
	    int ans = 0;
	    while(low <= high){
	        long mid = low + (high-low)/2;
	        if(canCut(mid,sweetness,N,K+1)){
	            ans = (int) mid;
	            low = mid + 1;
	        }
	        else{
	            high = mid - 1;
	        }
	    }
	    return ans;
	}
	public boolean canCut(long limit,int[] sweetness,int n,int k){
	    int i = 0 ; 
	    while(i < n){
	        long sum = 0;
	        while(i < n && sum < limit){
	            sum = sum + sweetness[i];
	            i++;
	        }
	        if(k > 0 && sum < limit) return false;
	        k--;
	    }
	    if(k <= 0) return true;
	    return false;
	    
	}
}