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
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        // Code here
        Queue<Tomato> bfs = new ArrayDeque<Tomato>();
        int m = grid.length;
        int n = grid[0].length;
        int minTime = 0;
        //adding rotten tomatoes to queue
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 2){
                    bfs.add(new Tomato(i,j,0));
                }
            }
        }
        while(!bfs.isEmpty()){
            Tomato temp = bfs.poll();
            //check 4-directionally for temp
            //right
            if(temp.j < n-1 && grid[temp.i][temp.j+1] == 1){
                    bfs.add(new Tomato(temp.i,temp.j+1,temp.time+1));
                    grid[temp.i][temp.j+1] = 2;
                }
            //left
            if(temp.j > 0 && grid[temp.i][temp.j-1] == 1 ){
                    bfs.add(new Tomato(temp.i,temp.j-1,temp.time+1));
                    grid[temp.i][temp.j-1] = 2;
                }
            //down
            if(temp.i < m-1 && grid[temp.i+1][temp.j] == 1 ){
                    bfs.add(new Tomato(temp.i+1,temp.j,temp.time+1));
                    grid[temp.i+1][temp.j] = 2;
                }
            //up
            if(temp.i > 0 && grid[temp.i-1][temp.j] == 1 ){
                    bfs.add(new Tomato(temp.i-1,temp.j,temp.time+1));
                    grid[temp.i-1][temp.j] = 2;
                }
             minTime = temp.time;   
        }
        //check if any tomatoes are left
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1){
                   return -1;
                }
            }
        }
        
        return minTime;
    }
}
class Tomato {
    int i;
    int j;
    int time;
    public Tomato(int i,int j,int time){
        this.i = i;
        this.j = j;
        this.time = time;
    }
}