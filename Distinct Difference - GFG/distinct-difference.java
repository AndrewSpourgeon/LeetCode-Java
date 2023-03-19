//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[] A = IntArray.input(br, N);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.getDistinctDifference(N, A);
            
            IntArray.print(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> getDistinctDifference(int N, int[] A) {
        // code here
        HashMap<Integer,Integer> left =new  HashMap<>();
        HashMap<Integer,Integer> right =new  HashMap<>();
        for(int val : A){
            right.put(val,right.getOrDefault(val,0)+1);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        right.put(A[0],right.get(A[0])-1);
        if(right.get(A[0])==0) right.remove(A[0]);
        ans.add(left.size()-right.size());
        left.put(A[0],1);
        for(int i = 1 ; i < N ; i++){
            right.put(A[i],right.get(A[i])-1);
            if(right.get(A[i])==0) right.remove(A[i]);
            ans.add(left.size()-right.size());
            left.put(A[i],left.getOrDefault(A[i],0)+1);
        }
        return ans;
    }
}
        
