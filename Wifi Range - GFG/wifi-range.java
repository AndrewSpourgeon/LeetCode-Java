//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int X = Integer.parseInt(input_line[1]);
            String S = read.readLine().trim();
            Solution ob = new Solution();
            boolean ans = ob.wifiRange(N, S, X); 
            if(ans)
            System.out.println(1);
            else
            System.out.println(0);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    boolean wifiRange(int N, String S, int X) 
    { 
        // code here
        StringBuilder sb = new StringBuilder(S);
        for(int i = 0 ; i < N ; i++){
            if(S.charAt(i) == '1'){
                int left = i-X , right = i + X , j = i;
                while(j >= left && j >= 0){
                    sb.setCharAt(j,'2');
                    j--;
                }
                j = i;
                while(j <= right && j < N){
                    sb.setCharAt(j,'2');
                    j++;
                }
            }
        }
        String s1 = sb.toString();
        for(int i = 0 ; i < N ; i++){
            if(s1.charAt(i) == '0') return false;
        }
        return true;
    }
} 