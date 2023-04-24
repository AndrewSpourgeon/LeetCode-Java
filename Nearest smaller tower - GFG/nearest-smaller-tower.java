//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int [] arr = new int[n];
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(str[i]);
			Solution ob = new Solution();
			int [] ans = ob.nearestSmallestTower(arr);
			for(int i = 0; i < n; i++)
				System.out.print(ans[i]+" ");
			System.out.println();
		}
		
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution{
	int[] nearestSmallestTower(int[] arr){
		//Write your code here
		int N=arr.length;
        int[] res = new int[N];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<N; i++) {
           if(stack.isEmpty()) {
               stack.push(i);
           } else if(arr[stack.peek()] < arr[i]) {
               res[i] = stack.peek();
               stack.push(i);
           } else if(arr[stack.peek()] == arr[i]) {
               res[i] = res[stack.peek()];  // 1 4 8 8 8 5 ->  Kind of Dp where you are using previous 8 information.
               stack.push(i);
           } else {
               while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                   int topIdx = stack.pop();
                   if(res[topIdx] == -1 || 
                   topIdx-res[topIdx] > i-topIdx || 
                   (topIdx-res[topIdx] == i-topIdx && 
                   arr[i] < arr[res[topIdx]])) {
                       res[topIdx] = i;
                   }
               }
               // after above popping loop, 1 4 6 8 5 can become 1 4 5 so set 5's smaller element as 4.  clever technique right ?
               if(!stack.isEmpty()) {
                   if(arr[stack.peek()] == arr[i]) {
                       res[i] = res[stack.peek()]; // 0 3 4 1 5 10 1 1 -> 1 at 3rd Idx has smaller element as 0. use this information for last ones.
                   } else {
                       res[i] = stack.peek();
                   }
               }
               stack.push(i);
           }
        }
        return res;
	}
}