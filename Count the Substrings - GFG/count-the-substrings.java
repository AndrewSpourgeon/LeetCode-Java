//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.countSubstring(S);
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int countSubstring(String S) 
    { 
        // code here
        int n = S.length(),count=0;
        for(int i = 0 ; i < n ; i++){
            int low = Character.isUpperCase(S.charAt(i)) ? 0 : 1;
            int high = Character.isUpperCase(S.charAt(i)) ? 1 : 0;
            for(int j = i+1 ; j < n ; j++){
                if(Character.isUpperCase(S.charAt(j))){
                    high++;
                }
                else{
                    low++;
                }
                if(high == low) count++;
            }
        }
        return count;
    }
} 
