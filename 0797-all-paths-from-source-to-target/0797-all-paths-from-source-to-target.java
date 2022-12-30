class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int starts = graph[0].length;
        List<List<Integer>> paths = new ArrayList<List<Integer>>();
        for(int i = 0 ; i < starts ; i++){
            List<Integer> path = new ArrayList<Integer>(Arrays.asList(0));
            solve(graph[0][i],graph.length,graph,path,paths);
        }
        return paths;
    }

    private void solve(int i , int limit , int[][] graph , List<Integer> path,List<List<Integer>> paths){
        if(i == limit-1){
            path.add(i);
            paths.add(new ArrayList<Integer>(path));
            path.remove(path.size()-1);
            return;
        }
        
        for(int j = 0 ; j < graph[i].length ; j++){
            path.add(i);
            solve(graph[i][j],limit,graph,path,paths);
            path.remove(path.size()-1);
        }


    }
}