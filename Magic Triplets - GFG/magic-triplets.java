//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] S = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int ans = ob.countTriplets(nums);
            System.out.println(ans);         
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public int countTriplets(int[] nums){
        // code here
        int len = nums.length;
        if(len < 3) return 0;
        int count = 0;
        for(int j = 1 ; j < len-1 ; j++){
            int less = 0;
            int high = 0;
            for(int i = 0 ; i < j ; i++){
                if(nums[i] < nums[j]){
                    less = less + 1;
                }
            }
            for(int k = j + 1 ; k < len ; k++){
                if(nums[j] < nums[k]){
                    high = high + 1;
                }
            }
            count = count + (less * high);
            
        }
        return count;
    }
}