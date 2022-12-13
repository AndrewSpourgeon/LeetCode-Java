//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int splitArray(int[] arr , int n, int k) {
        // code here
        int low = Integer.MAX_VALUE;
        int high = 0;
        for(int i = 0 ; i < n ; i++){
            high += arr[i];
            low = Math.min(low,arr[i]);
        }
        
        while(low <= high){
            int mid = (low+high)/2;
            if(canSplit(mid,k,arr,n) == true){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
    
    private static boolean canSplit(int mid , int k , int[] arr,int n){
        int curSum = 0 , parts = 1;
        for(int i = 0 ; i < n ; i++){
            if(arr[i] > mid) return false;
            else if(curSum + arr[i] >  mid){
                curSum = arr[i];
                parts++;
            }
            else{
                curSum += arr[i];
            }
        }
        if(parts <= k){
            return true;
        }
        return false;
    }
};