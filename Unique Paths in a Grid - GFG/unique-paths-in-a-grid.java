//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            
            int [][] grid = new int[n][m];
            for(int i=0; i<n; i++)
            {
                String S1[] = read.readLine().split(" ");
                for(int j=0; j<m; j++)
                {
                    grid[i][j] = Integer.parseInt(S1[j]);
                }
            }

            Solution ob = new Solution();
            System.out.println(ob.uniquePaths(n,m,grid));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int uniquePaths(int n, int m, int[][] grid) {
        // code here
        if(grid[0][0] == 0 || grid[n-1][m-1] == 0) return 0;
        long[][] dp = new long[n][m];
        for(long[] temp : dp){
            Arrays.fill(temp,-1);
        }
        long mod = 1000000000+7;
        return (int)(solve(0,0,n,m,grid,dp) % mod);

    }
    public static long solve(int i,int j,int n, int m, int[][] grid,long[][] dp){
        if(i == n-1 && j == m-1) return 1;
        if(i >= n || j >= m) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        long count = 0,mod = 1000000000+7;
        if(i+1 < n && grid[i+1][j]==1){
            count += (solve(i+1,j,n,m,grid,dp)%mod);
        }
        if(j+1 < m && grid[i][j+1]==1){
            count += (solve(i,j+1,n,m,grid,dp)%mod);
        }
        return dp[i][j] = count % mod;
        
    }
};