class Solution {
    int ans = 0;
    int obs = 0;
    public int uniquePathsIII(int[][] grid) {
        Pair start = null , end = null ;
        int rows = grid.length , cols = grid[0].length;
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                if(grid[i][j] == 1) start = new Pair(i,j);
                if(grid[i][j] == 2) end = new Pair(i,j);
                if(grid[i][j] == -1) obs++;
            }
        }
        int[][] vis = new int[rows][cols];
        for(int temp = 0 ; temp < vis.length ; temp ++){
            Arrays.fill(vis[temp],-1);
        }
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        for(int i = 0 ; i < dir.length ; i++){
            int m = start.row + dir[i][0];
            int n = start.col + dir[i][1];
            vis[start.row][start.col] = 1;
            if(canMove(m,n,grid,vis)){
                solve(m,n,grid,vis,end,1);
            }
            vis[start.row][start.col] = -1;
        }
        return ans;
    }

    private void solve(int i , int j , int[][] grid , int[][] vis, Pair end,int count){
        if(i == end.row && j == end.col && count == (grid.length * grid[0].length)-obs-1){
            ans = ans + 1;
            return;
        }
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        for(int k = 0 ; k < dir.length ; k++){
            int m = i + dir[k][0];
            int n = j + dir[k][1];
            vis[i][j] = 1;
            if(canMove(m,n,grid,vis)){
                solve(m,n,grid,vis,end,count+1);
            }
            vis[i][j] = -1;
        }
    }

    private boolean canMove(int i , int j , int[][] grid , int[][] vis){
        return (i < grid.length && i >= 0 && j < grid[0].length && j >=0 && grid[i][j] != -1 && vis[i][j] == -1);
    }
}


class Pair{
    int row;
    int col;
    public Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}