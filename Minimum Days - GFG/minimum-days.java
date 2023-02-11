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
        PrintWriter out=new PrintWriter(System.out);
        
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            String S;
            S = br.readLine();
            
            
            int[] P = IntArray.input(br, N);
            
            Solution obj = new Solution();
            int res = obj.getMinimumDays(N, S, P);
            
            out.println(res);
            
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public static int getMinimumDays(int N, String S, int[] P) {
        // code here
        int cons = 0;
    for (int i = 0; i < S.length() - 1; i++) {
        if (S.charAt(i) == S.charAt(i + 1)) {
            cons++;
        }
    }
    char[] SArr = S.toCharArray();
    if (cons == 0) {
        return 0;
    }
    for (int i = 0; i < N; i++) {
        int index = P[i];
        if (index != 0 && SArr[index] == SArr[index - 1]) {
            cons--;
        }
        if (index != N - 1 && SArr[index] == SArr[index + 1]) {
            cons--;
        }
        if (cons == 0) {
            return i + 1;
        }
        SArr[index] = '?';
    }
    return -1;
    }
}
