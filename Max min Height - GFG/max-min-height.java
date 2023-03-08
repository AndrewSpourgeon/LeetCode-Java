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
			int N, K, W;
			String [] str = br.readLine().trim().split(" ");
			N = Integer.parseInt(str[0]);
			K = Integer.parseInt(str[1]);
			W = Integer.parseInt(str[2]);
			str = br.readLine().trim().split(" ");
			int [] arr = new int[N];
			for(int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(str[i]);
			Solution obj = new Solution();
			System.out.println(obj.maximizeMinHeight(N, K, W,arr));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
	long maximizeMinHeight(int N, int K, int W,int [] a)
    {
        //Write your code here
        long low = Arrays.stream(a).min().getAsInt();
        long high = low + K + 1;
        long ans = 0;
        while(low <= high){
            long mid = low + (high-low)/2;
            if(canGrow(mid,N,K,W,a)){
                ans = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return ans;
    }
    boolean canGrow(long reqHt,int N,int rem,int limit,int[] arr){
        
        long[] watered = new long[N];
        if(arr[0] < reqHt){
            watered[0] += reqHt - arr[0];
            rem -= reqHt - arr[0];
        }
        if(rem < 0) return false;
        for(int i = 1 ; i < N ; i++){
            watered[i] = watered[i-1];
            int curHt = arr[i];
            if(i >= limit){
                curHt += (watered[i] - watered[i-limit]);
            }
            else{
                curHt += watered[i];
            }
            if(curHt < reqHt){
                watered[i] += reqHt - curHt;
                rem -= reqHt - curHt;
            }
            if(rem < 0) return false;
        }
        return true;
        
    }
}
