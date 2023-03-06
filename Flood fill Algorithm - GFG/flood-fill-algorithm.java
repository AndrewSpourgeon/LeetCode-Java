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
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] image =  new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    image[i][j] = Integer.parseInt(S2[j]);
            }
            String[] S3 = br.readLine().trim().split(" ");
            int sr = Integer.parseInt(S3[0]);
            int sc = Integer.parseInt(S3[1]);
            int newColor = Integer.parseInt(S3[2]);
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int[][] floodFill(int[][] image, int sr, int sc, int color)
    {
        // Code here
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr,sc});
        int target = image[sr][sc];
        image[sr][sc] = color;
        int m = image.length,n = image[0].length;
        int[][] vis = new int[m][n];
        vis[sr][sc] = 1;
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int i = 0 ; i < 4 ; i++){
                int x = cur[0] + dir[i][0];
                int y = cur[1] + dir[i][1];
                if(isSafe(x,y,m,n,image,target,vis)){
                    image[x][y] = color;
                    vis[x][y] = 1;
                    queue.add(new int[]{x,y});
                }
            }
        }
        return image;
    }
    public boolean isSafe(int x,int y,int m,int n,int[][] image,int target,int[][] vis){
        return x >= 0 && y >= 0 && x < m && y < n && vis[x][y] == 0 && image[x][y] == target;
    }
    
}