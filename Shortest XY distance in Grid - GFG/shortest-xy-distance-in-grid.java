//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");

            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);

            ArrayList<ArrayList<Character>> grid = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                ArrayList<Character> col = new ArrayList<>();
                String S1[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    col.add(S1[j].charAt(0));
                }
                grid.add(col);
            }

            Solution ob = new Solution();
            System.out.println(ob.shortestXYDist(grid, N, M));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int shortestXYDist(ArrayList<ArrayList<Character>> grid, int N,
                              int M) {
        // code here
        ArrayList<Pair> xes = new ArrayList<>();
        ArrayList<Pair> yes = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(grid.get(i).get(j) == 'X'){
                    xes.add(new Pair(i,j));
                }
                else if(grid.get(i).get(j) == 'Y'){
                    yes.add(new Pair(i,j));
                }
            }
        }
        int mini = Integer.MAX_VALUE;
        for(Pair xp : xes){
            for(Pair yp : yes){
                mini = Math.min(mini , Math.abs(xp.x-yp.x)+Math.abs(xp.y-yp.y));
            }
        }
        return mini;
        
    }
};
class Pair{
    int x ; int y;
    Pair(int x , int y){
        this.x = x ; this.y = y;
    }
}