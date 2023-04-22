//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;

public class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            int n=Integer.parseInt(in.readLine());
            String s[]=in.readLine().trim().split(" ");
            int a[]=new int[n];
            for(int i=0;i<n;i++){
                a[i]=Integer.parseInt(s[i]);
            }
            Solution ob=new Solution();
            long ans[]=ob.smallerSum(n,a);
            for(long i:ans){
                out.print(i+" ");
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public long[] smallerSum(int n,int arr[])
    {
        ArrayList<Pair> pairs = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            pairs.add(new Pair(arr[i],i));
        }
        Collections.sort(pairs,new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                return p1.val-p2.val;
            }
        });
        
        long[] ans = new long[n];
        long prevSum = 0;
        int j=0;
        while(j < n){
            long dupSum = prevSum;
            while(j+1 < n && pairs.get(j).val == pairs.get(j+1).val){
                Pair p = pairs.get(j);
                ans[p.index] = prevSum;
                j++;
                dupSum += p.val;
            }
            Pair p = pairs.get(j);
            ans[p.index] = prevSum;
            dupSum += p.val;
            prevSum = dupSum;
            j++;
            
        }
        return ans;
    }
}
class Pair{
    int val;
    int index;
    Pair(int val , int index){
        this.val = val;
        this.index = index;
    }
}