//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.maxInstance(s);
            out.println(ans);
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maxInstance(String s) {
        // Code here
        int n = s.length();
        if(n < 7) return 0;
        int ans = Integer.MAX_VALUE;
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            char c = s.charAt(i);
            if(c=='b' || c=='a' || c == 'n'){
                map1.put(c ,map1.getOrDefault(c,0)+1);
            }
            else if(c=='l' || c=='o'){
                map2.put(c ,map2.getOrDefault(c,0)+1 );
            }
        }
        for(int val : map1.values()){
            ans = Math.min(val,ans);
        }
        for(int val : map2.values()){
            ans = Math.min(val/2,ans);
        }
        return ans;
    }
}