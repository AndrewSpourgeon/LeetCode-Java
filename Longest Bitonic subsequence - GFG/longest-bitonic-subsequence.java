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
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestBitonicSequence(int[] nums)
    {
        // Code here
        int len = nums.length;
        int[] front = new int[len];
        int[] back = new int[len];
        Arrays.fill(front,1);
        Arrays.fill(back,1);
        //forward increasing
        for(int i = 1 ; i < len ; i++){
            for(int j = 0 ; j < i ; j++){
                if(nums[j] < nums[i] && 1 + front[j] > front[i]){
                    front[i] = 1 + front[j];
                }
            }
        }
        
        //backward increasing
        for(int i = len-2 ; i >= 0 ; i--){
            for(int j = len-1 ; j > i ; j--){
                if(nums[j] < nums[i] && 1 + back[j] > back[i]){
                    back[i] = back[j] + 1;
                }
            }
        }
        int maxBit = 0;
        for(int i = 0 ; i < len ; i++){
            maxBit = Math.max(maxBit , front[i]+back[i] - 1);
        }
        return maxBit;
    }
}