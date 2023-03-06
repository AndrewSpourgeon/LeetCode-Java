//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.noConseBits(n);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int noConseBits(int n) {
        // code here
        if(n <= 6) return n;
        String bin = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder(bin);
        for(int i = 2 ; i < bin.length() ; i++){
            if(sb.charAt(i)=='1' && sb.charAt(i-1)=='1' && sb.charAt(i-2)=='1'){
                sb.setCharAt(i,'0');
            }
        }
        int ans = Integer.parseInt(sb.toString(),2);
        return ans;
    }
}
        
