//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            String T = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.checkCompressed(S,T));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int checkCompressed(String S, String T) {
        // code here
        int n = S.length() , m = T.length();
        if(T.matches("-?\\d+(\\.\\d+)?")){
            int val = Integer.valueOf(T);
            if(val == n) return 1;
            return 0;
        }
        int i = 0 , j = 0;
        while(i < n && j < m){
            boolean isNum = Character.isDigit(T.charAt(j));
            if(isNum){
                int prevJ = j;
                while(j < m && Character.isDigit(T.charAt(j))){
                    j++;
                }
                int jumps = Integer.valueOf(T.substring(prevJ,j));
                if(i+jumps < n ){
                    i += jumps;
                    continue;
                }
                if(n-i == jumps){
                    return 1;
                }
                else{
                    return 0;
                }
            }
            else{
                if(S.charAt(i) != T.charAt(j)){
                    return 0;
                }
                else{
                    i++;
                    j++;
                }
            }
        }
        return (i >= n && j >= m) ? 1 : 0;
    }
}