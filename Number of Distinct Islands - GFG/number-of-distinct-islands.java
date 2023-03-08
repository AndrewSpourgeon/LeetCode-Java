//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        Set<ArrayList<Integer>> set = new HashSet<>();
        int n = grid.length , m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    ArrayList<Integer> dp = new ArrayList<>();
                    dfs(new int[]{i,j},new int[]{i,j},grid,vis,dp,n,m);
                    set.add(dp);
                }
            }
        }
        // for(ArrayList<Pair> arr : set){
        //     for(Pair p : arr){
        //         System.out.print(p.x+" "+p.y+" ");
        //     }
        //     System.out.println();
        // }
        return set.size();
    }
    public void dfs(int[] cur,int[] base,int[][] grid,boolean[][] vis,ArrayList<Integer> dp,int n , int m){
        vis[cur[0]][cur[1]] = true;
        dp.add(cur[0]-base[0]);
        dp.add(cur[1]-base[1]);
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        for(int i = 0 ; i < 4 ; i++ ){
            int x = cur[0] + dir[i][0] , y = cur[1] + dir[i][1];
            if(x >= 0 && y >= 0 && x < n && y < m && !vis[x][y] && grid[x][y] == 1){
                dfs(new int[]{x,y},base,grid,vis,dp,n,m);
            }
        }
    }
}
