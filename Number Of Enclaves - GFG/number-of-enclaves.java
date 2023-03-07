//{ Driver Code Starts
// Initial Template for Java

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
            int ans = ob.numberOfEnclaves(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int numberOfEnclaves(int[][] a) {

        // Your code here
        int n = a.length , m = a[0].length;
        boolean[][] vis = new boolean[n][m];;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(!vis[i][j] && a[i][j] == 1){
                    if(i == 0 ){
                        bfs(i,j,n,m,vis,a);
                    }
                    else if(j == 0){
                        bfs(i,j,n,m,vis,a);
                    }
                    else if(i == n-1){
                        bfs(i,j,n,m,vis,a);
                    }
                    else if(j == m-1){
                        bfs(i,j,n,m,vis,a);
                    }
                }
            }
        }
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(!vis[i][j] && a[i][j] == 1) count++;
            }
        }
        return count;
        
    }
    public static void bfs(int x,int y,int n , int m,boolean[][] vis,int a[][]){
        vis[x][y] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            for(int i = 0 ; i <= 3 ; i++){
                int x1 = temp[0]+dir[i][0] , y1 = temp[1]+dir[i][1];
                if(x1 >=0 && y1 >=0 && x1 < n && y1 < m && !vis[x1][y1] && a[x1][y1]==1){
                    vis[x1][y1] = true;
                    queue.add(new int[]{x1,y1});
                }
            }
        }
        
    }
}