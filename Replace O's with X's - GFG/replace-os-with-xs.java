//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static char[][] fill(int n, int m, char a[][])
    {
        // code here
        boolean[][] vis = new boolean[n][m];;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(!vis[i][j] && a[i][j] == 'O'){
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
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(!vis[i][j] && a[i][j] == 'O') a[i][j] = 'X';
            }
        }
        return a;
        
    }
    public static void bfs(int x,int y,int n , int m,boolean[][] vis,char a[][]){
        vis[x][y] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            for(int i = 0 ; i <= 3 ; i++){
                int x1 = temp[0]+dir[i][0] , y1 = temp[1]+dir[i][1];
                if(x1 >=0 && y1 >=0 && x1 < n && y1 < m && !vis[x1][y1] && a[x1][y1]=='O'){
                    vis[x1][y1] = true;
                    queue.add(new int[]{x1,y1});
                }
            }
        }
        
    }
}