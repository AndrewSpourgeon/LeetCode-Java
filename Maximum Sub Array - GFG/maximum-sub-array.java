//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            ArrayList<Integer> ans = new Solution().findSubarray(a, n);
            for(int i:ans){
                out.print(i+" ");
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    ArrayList<Integer> findSubarray(int a[], int n) {
        // code here
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int i = 0 , j = 0 , maxi = 0 , maxj = 0 , sum = 0 , maxSum = 0 , maxWidth = 0;
        int len = a.length;
        while( i < len && j < len){
            if(a[j] >= 0 ){
                sum = sum + a[j];
                if(sum >= maxSum){
                    if(sum > maxSum){
                        maxi = i;
                        maxj = j;
                        maxWidth = j - i + 1;
                        maxSum = sum;
                    }
                    else if(j - i + 1 > maxWidth){
                        maxi = i;
                        maxj = j;
                        maxWidth = j - i + 1;
                    }
                }
                j = j + 1;
            }
            else{
                sum = 0;
                i = j + 1;
                j = j + 1;
            }
        }
        for(int iter = maxi ; iter <= maxj ; iter++){
            ans.add(a[iter]);
        }
        
        return maxWidth == 0 ? new ArrayList<Integer>(Arrays.asList(-1)) : ans;
    }
}