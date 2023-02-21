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
		int[][] vis = new int[N][M];
		int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
		int[] pair = new int[3];
		pair[0] = x-1 ; pair[1] = y-1 ; pair[2] = 0;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(pair);
		vis[x-1][y-1] = 1;
		
		while(!queue.isEmpty()){
		    int[] temp = queue.poll();
		    ans = Math.max(ans,temp[2]);
		    for(int i = 0 ; i < 4 ; i++){
		        int nextX = temp[0] + dir[i][0];
		        int nextY = temp[1] + dir[i][1];
		        if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && vis[nextX][nextY] != 1){
		            vis[nextX][nextY] = 1;
		            queue.add(new int[]{nextX,nextY,temp[2]+1});
		        }
		    }
		}
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