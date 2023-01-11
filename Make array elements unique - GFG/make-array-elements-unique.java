//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            
            int i = 0;
            int N = Integer.parseInt(br.readLine().trim());
        
            int arr[] = new int[(int)(N)];
            
            String inputLine2[] = br.readLine().trim().split(" ");
            for ( i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(inputLine2[i]);
            }
        
            Solution ob = new Solution();
            System.out.println(ob.minIncrements(arr,N));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public long minIncrements(int[] arr, int N) {
        // Code here
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int val : arr){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        long ans = 0L;
        HashMap<Integer,Integer> tempMap = new HashMap<>(map);
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() > 1){
                int freq = entry.getValue();
                int key = entry.getKey();
                while(freq > 1){
                    int next = key + 1;
                    while(tempMap.keySet().contains(next)){
                        next++;
                    }
                    tempMap.put(next,1);
                    ans += next - key;
                    freq--;
                }
            }
        }
        
        return ans;
    }
}