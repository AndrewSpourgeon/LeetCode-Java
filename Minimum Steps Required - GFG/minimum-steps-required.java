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
			String str = br.readLine();
			Solution obj = new Solution();
			System.out.println(obj.minSteps(str));
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
	int minSteps(String str) {
		//Write your code here
		StringBuilder sb = new StringBuilder();
		int i = 0 , n = str.length();
		while(i < n){
		    if(str.charAt(i) == 'a'){
		        while(i < n && str.charAt(i)=='a'){
		            i++;
		        }
		        sb.append("a");
		    }
		    else{
		        while(i < n && str.charAt(i)=='b'){
		            i++;
		        }
		        sb.append("b");
		    }
		}
		String dp = sb.toString();
		int aCount = 0 , bCount = 0;
		for(int j = 0 ; j < dp.length() ; j++){
		    if(dp.charAt(j) == 'a') aCount++;
		    else bCount++;
		}
		return Math.min(aCount,bCount) + 1;
	}
}