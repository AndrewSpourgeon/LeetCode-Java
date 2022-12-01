//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main (String[] args)throws IOException
	{

// 		Scanner in = new Scanner(System.in);
        
// 		int t = in.nextInt();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
         //testcases
        int t = Integer.parseInt(read.readLine());
		
		while(t-- >0)
		{
		    //size of array
		    int n = Integer.parseInt(read.readLine());
		    long[] arr= new long[n];
		    
		    String str[] = read.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0;i<n;i++)
		        arr[i] = Long.parseLong(str[i]);
		    
		    // StringBuffer sb = new StringBuffer();
		    
		    Solution ob = new Solution();
		    
		    //calling rearrange() function
		    ob.rearrange(arr, n);
		    StringBuffer sb = new StringBuffer();
		    
		    //appending and printing the elements
		    for(int i =0; i < n; i++)
		     sb.append(arr[i] + " ");
		    System.out.println(sb);
		}
	}
}




// } Driver Code Ends


class Solution{
    
    // temp: input array
    // n: size of array
    //Function to rearrange  the array elements alternately.
    public static void rearrange(long arr[], int n){
        
        // Your code here
        // Queue<Long> minHeap = new PriorityQueue<Long>();
        // Queue<Long> maxHeap = new PriorityQueue<Long>(Collections.reverseOrder());
        // for(int i = 0 ; i < n ; i++){
        //     minHeap.add(arr[i]);
        //     maxHeap.add(arr[n-i-1]);
        // }
        
        // for(int i = 0 ; i < n ; i= i + 2){
            
        //         arr[i] = maxHeap.poll();    
            
        //     if(i+1 < n)
        //       arr[i+1] = minHeap.poll();    
            
            
        // }
        int i = 0 ;
        int j = n-1;
        int k = 0;
        long[] ans = new long[n];
        while(i < j){
           ans[k] = arr[j];
           ans[k+1] = arr[i];
           j--;
           i++;
           k=k+2;
        }
        if(i==j){
            ans[n-1] = arr[i];
        }
        
        for(int iter = 0 ; iter < n ; iter++){
            arr[iter] = ans[iter];
        }
            
             
        
    }
    
}


