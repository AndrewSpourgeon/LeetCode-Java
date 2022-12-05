//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(St[0]);
            int m = Integer.parseInt(St[1]);
            int k = Integer.parseInt(St[2]);
            
            int[][] mat = new int[n][m];
            
            for(int i=0; i<n; i++)
            {
                String S[] = read.readLine().split(" ");
                for(int j=0; j<m; j++)
                    mat[i][j] = Integer.parseInt(S[j]);
            }

            Solution ob = new Solution();
            System.out.println(ob.shotestPath(mat,n,m,k));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static class Node{
        int i;
        int j;
        int k;
        int dis;
        public Node(int i , int j , int k , int dis){
            this.i = i;
            this.j = j;
            this.k = k;
            this.dis = dis;
        }
    }
    public static int shotestPath(int[][] arr, int n, int m, int k) {
        int rows = n;
        int cols = m;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0 , 0 , 0 , 0));
        int[][] isVis = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(isVis[i] , Integer.MAX_VALUE);
        }
        int[][] dis = { { 0 , -1 } ,{ 0 , 1 } , { 1 , 0 } , { -1 , 0 } };
        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            int i = curNode.i;
            int j = curNode.j;
            if(i == n-1 && j == m - 1) return curNode.dis;
            if(curNode.k >= isVis[i][j]) continue;
            isVis[i][j] = curNode.k;
            int temp = 0;
            if(arr[i][j] == 1) temp++;
            int K = temp + curNode.k;
            if(K > k) continue;
            for(int ptr = 0 ; ptr < dis.length ; ptr++){
                int I = dis[ptr][0] + i;
                int J = dis[ptr][1] + j;
                if(I < rows && I >= 0 && J < cols && J >= 0 && isVis[I][J] > K){
                    queue.offer(new Node(I , J , K , curNode.dis + 1));
                }
            }
        }
        return -1;
    }
    
};