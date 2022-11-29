//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.numoffbt(a, n));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static int MOD = 1000000007;
    public static int numoffbt(int arr[], int n) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        int ans = 0;

        boolean[] visited = new boolean[max + 1];

        int[] solution = new int[max + 1];

        for(int i = 0; i < n; i++) {
            visited[arr[i]] = true;
            solution[arr[i]] = 1;
        }

for(int i = min; i <= max; i++) {

    if(visited[i]) {

    for(int j = 2; i * j <= max && j <= i; j++) {

        int product = i * j;

        if(visited[product]) {

solution[product] = (solution[product] + (solution[i] * solution[j]) % MOD) % MOD;

        if(i != j) {

solution[product] = (solution[product] + (solution[i] * solution[j]) % MOD) % MOD;

                    }
                }
            }
        ans = (ans + solution[i]) % MOD;
            }
        }
        return ans;

    }

}