//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        int n = grid.length , m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    count++;
                    dfs(i,j,grid,vis);
                }
            }
        }
        return count;
    }
    public void dfs(int i,int j,char[][] grid,boolean[][] vis){
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
        vis[i][j] = true;
        for(int k = 0 ; k < 8 ; k++){
            int x = i + dir[k][0], y = j + dir[k][1];
            if(canMove(x,y,grid,vis)){
                dfs(x,y,grid,vis);
            }
        }
    }
    public boolean canMove(int i,int j,char[][] grid,boolean[][] vis){
        int n = grid.length , m = grid[0].length;
        return i>=0 && j>=0 && i<n && j<m && grid[i][j]=='1' && !vis[i][j];
    }
}