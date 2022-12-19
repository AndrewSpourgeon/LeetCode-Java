//{ Driver Code Starts
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
            int k = sc.nextInt();

            int tmp = sc.nextInt();
            int[][] flights = new int[tmp][3];
            for (int i = 0; i < tmp; i++) {

                int u1 = sc.nextInt();
                int v1 = sc.nextInt();
                int w1 = sc.nextInt();
                flights[i][0] = u1;
                flights[i][1] = v1;
                flights[i][2] = w1;
            }

            Solution ob = new Solution();
            int ans = ob.minimumCost(flights, n, k);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int minimumCost(int[][] flights, int n, int k) {
        // Your code here
        int mod = 10000009; 
        HashMap<Integer,ArrayList<Pair>> map = new HashMap<>();
        for(int[] temp : flights){
            if(map.keySet().contains(temp[0])){
                map.get(temp[0]).add(new Pair(temp[1],temp[2]));
            }
            else{
                map.put(temp[0],new ArrayList<Pair>(Arrays.asList(new Pair(temp[1],temp[2]))));
            }
        }
        int[] costs = new int[n+1];
        Arrays.fill(costs,mod);
        costs[k] = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(k);
        while(!queue.isEmpty()){
            int temp = queue.poll();
            if(map.keySet().contains(temp)){
                 ArrayList<Pair> cons = map.get(temp);
                for(int i = 0 ; i < cons.size() ; i++){
                    Pair child = cons.get(i);
                    if(costs[temp] + child.weight < costs[child.ver]){
                        costs[child.ver] = costs[temp] + child.weight;
                        queue.add(child.ver);
                    }
                }
            }
        }
        int ans = 0;
        for(int i = 1 ; i < n+1 ; i++){
            if(costs[i] == mod){
                return -1;
            }
            ans = Math.max(ans,costs[i]);
        }
        return ans;
    }
}

class Pair{
    int ver;
    int weight;
    public Pair(int c,int w){
        ver = c;
        weight = w;
    }
}
