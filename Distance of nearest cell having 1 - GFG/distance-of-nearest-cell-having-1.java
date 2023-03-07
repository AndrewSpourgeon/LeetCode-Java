//{ Driver Code Starts
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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<Node> bfs = new LinkedList<Node>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    bfs.add(new Node(i,j,0));
                    grid[i][j] = 0;
                    vis[i][j] = true;
                }
            }
        }
        int[][] dir = {{0,1},{-1,0},{0,-1},{1,0}};
        while(!bfs.isEmpty()){
            Node temp = bfs.poll();
            for(int i = 0 ; i < dir.length ; i++){
                int I = dir[i][0] + temp.i;
                int J = dir[i][1] + temp.j;
                if(I >= 0 && I < n && J >= 0 && J < m && !vis[I][J] && grid[I][J] == 0){
                    vis[I][J] = true;
                    grid[I][J] = temp.count + 1;
                    bfs.add(new Node(I,J,temp.count+1));
                }
            }
        }
        return grid;
    }
}

class Node {
    int i;
    int j;
    int count;
    public Node(int i , int j,int count){
        this.i = i;
        this.j = j;
        this.count = count;
    }
}