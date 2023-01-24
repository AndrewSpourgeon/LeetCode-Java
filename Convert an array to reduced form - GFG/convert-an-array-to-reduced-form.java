//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().convert(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Pair{
    int val;
    int index;
    Pair(int val , int index){
        this.val = val;
        this.index = index;
    }
}
class Solution {
    void convert(int[] arr, int n) {
        //Code here
        PriorityQueue<Pair> heap = new PriorityQueue<>(new ValueComparator());
        for(int i = 0 ; i < n ; i++){
            heap.add(new Pair(arr[i],i));
        }
        for(int i = 0 ; i < n ; i++){
            Pair temp = heap.poll();
            arr[temp.index] = i;
        }
    }
}
class ValueComparator implements Comparator<Pair> {
    @Override
    public int compare(Pair p1, Pair p2) {
       return Integer.compare(p1.val, p2.val);
    }

}