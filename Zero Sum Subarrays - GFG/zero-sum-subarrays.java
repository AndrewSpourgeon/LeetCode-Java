//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		    int n;
		    n=sc.nextInt();
		    
		    long arr[]=new long[n];
	
		    
		    for(int i=0;i<n;i++)
		    {
		        arr[i]=sc.nextLong();
		    }
            Solution ob = new Solution();
		    System.out.println(ob.findSubarray(arr,n));
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    //Function to count subarrays with sum equal to 0.
    public static long findSubarray(long[] arr ,int n) 
    {
        //Your code here
        HashMap<Long,Integer> map = new HashMap<>();
        long sum = 0;
        for(int i =0 ; i < n ; i++){
            sum = sum + arr[i];
            if(!map.keySet().contains(sum)){
                map.put(sum,1);
            }
            else{
                map.put(sum,map.get(sum)+1);
            }
        }
        long ans = 0;
        for(Map.Entry<Long,Integer> entry : map.entrySet()){
            int val = entry.getValue();
            if(entry.getKey() == 0){
                ans = ans + ( ((val)*(val+1)) / 2 );
            }
            else{
                ans = ans + ( ((val-1)*(val)) / 2 );
            }
        }
        return ans;
    }
}