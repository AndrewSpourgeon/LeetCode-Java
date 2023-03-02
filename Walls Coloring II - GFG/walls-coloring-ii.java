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
			int [][] costs = new int[n][k];
			for(int i = 0; i < n; i++) {
				str = br.readLine().trim().split(" ");
				for(int j = 0; j < k; j++) {
					costs[i][j] = Integer.parseInt(str[j]);
				}
			}
			Solution obj = new Solution();
			System.out.println(obj.minCost(costs));
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
	int minCost(int [][] costs) {
		//Write your code here
		int n = costs.length , k = costs[0].length;
		//base cases
		if(n==0 || k== 0) return -1;
		if(n > 1 && k== 1) return -1;
		if(n==1 && k==1) return costs[0][0];
		int[][] dp = new int[n][k];
		
		int min = Integer.MAX_VALUE , sMin = Integer.MAX_VALUE; 
		for(int i = 0 ; i < k ; i++){
		    int val = costs[0][i];
		    dp[0][i] = val;
		    if(val < min){
		        sMin = min;
		        min = val;
		    }
		    else if(val < sMin){
		        sMin = val;
		    }
		}
		for(int i = 1 ; i < n ; i++){
		    int cMin = Integer.MAX_VALUE , csMin = Integer.MAX_VALUE; 
		    for(int j = 0 ; j < k ; j++){
		        if(dp[i-1][j] == min){
		            dp[i][j] = costs[i][j] + sMin;
		        }
		        else{
		            dp[i][j] = costs[i][j] + min;
		        }
		        int val = dp[i][j];
		        if(val < cMin){
    		        csMin = cMin;
    		        cMin = val;
    		    }
    		    else if(val < csMin){
    		        csMin = val;
    		    }
		    }
		    min = cMin;
		    sMin = csMin;
		}
		
		int ans = Integer.MAX_VALUE;
		for(int val : dp[n-1]){
		    ans = Math.min(ans,val);
		}
		
		return ans;
	}
}