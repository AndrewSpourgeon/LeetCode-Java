//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int E = Integer.parseInt(s[0]);
            int V = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i <= V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            int ans = obj.findNumberOfGoodComponent(V, adj);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findNumberOfGoodComponent(int v, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int ans = 0;
        boolean[] vis = new boolean[v+1];
        for(int i = 1 ; i <= v ; i++){
            if(!vis[i]){
                ArrayList<Integer> nodes = new ArrayList<Integer>();
                dfs(i,vis,nodes,adj);
                boolean bad = false;
                for(int key : nodes){
                    if(adj.get(key).size() < nodes.size() -1){
                        bad = true;
                        break;
                    }
                }
                if(!bad) ans++;
            }
        }
        return ans;
    }
    
    public void dfs(int i , boolean[] vis , ArrayList<Integer> nodes , ArrayList<ArrayList<Integer>> adj ){
        nodes.add(i);
        vis[i] = true;
        for(int child : adj.get(i)){
            if(!vis[child]){
                dfs(child,vis,nodes,adj);
            }
        }
    }
}