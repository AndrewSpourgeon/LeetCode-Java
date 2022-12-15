//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Position this line where user code will be pasted.
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.BalancedString(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static String BalancedString(int N) {
        // code here
        StringBuilder sb = new StringBuilder();
        String ans = "";
        if(N >= 26){
            int extra = N % 26;
            int times = N / 26;
            
            for(int i = 1 ; i <= times ; i++){
                for(int j = 1 ; j <= 26 ; j++){
                    sb.append(Character.toString(96+j));
                }
            }
            //////
            //even
                if(N%2 == 0){
                for(int i = 1 ; i <= extra/2 ; i++){
                    sb.append(Character.toString(96+i));
                }
                for(int i = 123-(extra/2) ; i <= 122 ; i++){
                    sb.append(Character.toString(i));
                }
                ans = sb.toString();
            }
            //odd
            else{
                String temp = Integer.toString(N);
                int sum = 0;
                for(int i = 0 ; i < temp.length() ; i++){
                    sum += temp.charAt(i)-'0' ; 
                }
                //if sum is even
                if(sum%2==0){
                    for(int i = 1 ; i <=(extra+1)/2 ; i++){
                        sb.append(Character.toString(96+i));
                    }
                    for(int i = 123-((extra-1)/2) ; i <=122 ; i++){
                        sb.append(Character.toString(i));
                    }
                    ans = sb.toString();
                }
                //if sum is odd
                else{
                    for(int i = 1 ; i <=(extra-1)/2 ; i++){
                        sb.append(Character.toString(96+i));
                    }
                    for(int i = 123-((extra+1)/2) ; i <=122 ; i++){
                        sb.append(Character.toString(i));
                    }
                    ans = sb.toString();
                }
            }
            
            ////
            
            
            
            
        }
        else{
            //even
            if(N%2 == 0){
                for(int i = 1 ; i <= N/2 ; i++){
                    sb.append(Character.toString(96+i));
                }
                for(int i = 123-(N/2) ; i <= 122 ; i++){
                    sb.append(Character.toString(i));
                }
                ans = sb.toString();
            }
            //odd
            else{
                String temp = Integer.toString(N);
                int sum = 0;
                for(int i = 0 ; i < temp.length() ; i++){
                    sum += temp.charAt(i)-'0' ; 
                }
                //if sum is even
                if(sum%2==0){
                    for(int i = 1 ; i <=(N+1)/2 ; i++){
                        sb.append(Character.toString(96+i));
                    }
                    for(int i = 123-((N-1)/2) ; i <=122 ; i++){
                        sb.append(Character.toString(i));
                    }
                    ans = sb.toString();
                }
                //if sum is odd
                else{
                    for(int i = 1 ; i <=(N-1)/2 ; i++){
                        sb.append(Character.toString(96+i));
                    }
                    for(int i = 123-((N+1)/2) ; i <=122 ; i++){
                        sb.append(Character.toString(i));
                    }
                    ans = sb.toString();
                }
            }
        }
        return ans;
    }
}