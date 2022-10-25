class Solution {
    public int orangesRotting(int[][] grid) {
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