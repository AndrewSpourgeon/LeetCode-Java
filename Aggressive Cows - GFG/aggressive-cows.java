//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int low = 1 , high = stalls[n-1] - stalls[0];
        //find max and min
        int ans = 0;
        int prevCow = 0;
        while(low <= high){
            int cows = k;
            int mid = (low+high)/2;
            for(int i = 0 ; i < n ; i++){
                if(i == 0){
                    prevCow = stalls[i];
                    cows--;
                }
                else{
                    if(stalls[i] - prevCow >= mid){
                        prevCow = stalls[i];
                        cows--;
                    } 
                }
                if(cows == 0){
                    break;
                }
            }
            //if perfectly placed then increase low
            if(cows == 0){
                low = mid + 1;
                ans = mid;
            }
            //if cows are still left , then decrease high
            else if(cows > 0){
                high = mid - 1;
            }
            else if(cows < 0){
                low = mid + 1;
            }
        }
        return ans;
    }
}