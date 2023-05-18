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
            String[] str = br.readLine().trim().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            int[][] matrix = new int[N][M];
            for(int i=0; i<N; i++)
            {
                String[] s = br.readLine().trim().split(" ");
                for(int j=0; j<M; j++)
                    matrix[i][j] = Integer.parseInt(s[j]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.closedIslands(matrix, N, M));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int closedIslands(int[][] matrix, int N, int M)
    {
        // Code here
        int count = 0;
        boolean[][] vis = new boolean[N][M];
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(isBound(i,j,N,M) && !vis[i][j] && matrix[i][j] == 1){
                    dfs1(i,j,N,M,vis,matrix);
                }
            }
        }
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(!vis[i][j] && matrix[i][j] == 1){
                    dfs2(i,j,N,M,vis,matrix);
                    count++;
                }
            }
        }
        return count;
        
    }
    public void dfs1(int x,int y,int n,int m,boolean[][] vis,int[][] matrix){
        vis[x][y] = true;
        matrix[x][y] = 0;
        int[][] dp = {{1,0},{0,1},{-1,0},{0,-1}};
        for(int i = 0 ; i < 4 ; i++){
            int nX = x + dp[i][0];
            int nY = y + dp[i][1];
            if(nX < n && nX >= 0 && nY < m && nY >= 0 && !vis[nX][nY] && matrix[nX][nY] == 1){
                dfs1(nX,nY,n,m,vis,matrix);
            }
        }
    }
    public void dfs2(int x,int y,int n,int m,boolean[][] vis,int[][] matrix){
        vis[x][y] = true;
        int[][] dp = {{1,0},{0,1},{-1,0},{0,-1}};
        for(int i = 0 ; i < 4 ; i++){
            int nX = x + dp[i][0];
            int nY = y + dp[i][1];
            if(nX < n && nX >= 0 && nY < m && nY >= 0 && !vis[nX][nY] && matrix[nX][nY] == 1){
                dfs2(nX,nY,n,m,vis,matrix);
            }
        }
    }
    
    public boolean isBound(int i , int j ,int n , int m){
        return (i == n-1 || i == 0 || j == 0 || j == m-1);
    }
}