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
        int[][] ans = new int[n][m];
        ArrayDeque<Node> bfs = new ArrayDeque<Node>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    bfs.add(new Node(i,j));
                }
                else{
                    ans[i][j] = -1;
                }
            }
        }
        int[][] dir = {{0,1},{-1,0},{0,-1},{1,0}};
        while(!bfs.isEmpty()){
            Node temp = bfs.poll();
            for(int i = 0 ; i < dir.length ; i++){
                int I = dir[i][0] + temp.i;
                int J = dir[i][1] + temp.j;
                if(I >= 0 && I < n && J >= 0 && J < m && ans[I][J] == -1){
                    ans[I][J] = ans[temp.i][temp.j] + 1;
                    bfs.add(new Node(I,J));
                }
            }
        }
        return ans;
    }
}

class Node {
    int i;
    int j;
    public Node(int i , int j){
        this.i = i;
        this.j = j;
    }
}