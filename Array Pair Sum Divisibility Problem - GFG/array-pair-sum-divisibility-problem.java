//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine().trim();
            String[] S1 = s1.split(" ");
            int n = Integer.parseInt(S1[0]);
            int k = Integer.parseInt(S1[1]);
            String s2 = br.readLine().trim();
            String[] S2 = s2.split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(S2[i]);
            }
            Solution ob = new Solution();
            boolean ans = ob.canPair(nums, k);
            if (ans)
                System.out.println("True");
            else
                System.out.println("False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public boolean canPair(int[] nums, int k) {
        // Code here
        int len = nums.length;
        if(len < 2) return false;
        if(len % 2 != 0) return false;
        HashMap<Integer,Integer> freq = new HashMap<Integer,Integer>();
        //storing frequencies of all reminders
        for(int i = 0 ; i < len ; i++){
            int rem = nums[i] % k;
            if(!freq.containsKey(rem)){
                freq.put(rem , 1);
            }
            else{
                freq.put(rem,freq.get(rem)+1);
            }
        }
        
        //finding pairs
        for(int i = 0 ; i < len ; i++){
            int rem = nums[i] % k;
            if(k/2 == rem){
                if(freq.get(rem)%2 != 0) return false;
            }
            else if(rem == 0){
                if(freq.get(0)%2 != 0) return false;
            }
            else{
                if(freq.get(rem) != freq.get(k-rem)) return false;
            }
        }
        
        return true;
    }
}