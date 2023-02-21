//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
	public static int minIteration(int N, int M, int x, int y){
		//code here
		
		if(N == 1 && M == 1)return 0; 
		
		int ans = 0;
		
		int X = x-1 , Y = y -1;
		
		//top left 
		ans = Math.max(ans , X+Y );
		//bottom left
		ans = Math.max(ans , (N-(X+1))+Y);
		//top right
		ans = Math.max(ans , X + (M-(Y+1)) );
		// bottom right
		ans = Math.max(ans,(N-(X+1))+(M-(Y+1)) );
		
		return ans;
		
	}
}


//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
        	String input[]=read.readLine().trim().split(" ");
            int N = Integer.parseInt(input[0]);
            int M=Integer.parseInt(input[1]);
           	input=read.readLine().trim().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            Solution ob = new Solution();
            System.out.println(ob.minIteration(N, M, x, y));
        }
        
    }
}
// } Driver Code Ends