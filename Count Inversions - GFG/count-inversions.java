//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        int n = (int)N-1;
        long ans[] = new long[1];
        mergeSort(arr,0,n,ans);
        return ans[0];
    }
    
    static void merge(long arr[], int p, int q, int r,long[] ans) {

        // Create L ← A[p..q] and M ← A[q+1..r]
        int n1 = q - p + 1;
        int n2 = r - q;
    
        long L[] = new long[n1];
        long M[] = new long[n2];
    
        for (int i = 0; i < n1; i++)
          L[i] = arr[p + i];
        for (int j = 0; j < n2; j++)
          M[j] = arr[q + 1 + j];
    
        // Maintain current index of sub-arrays and main array
        int i, j, k;
        i = 0;
        j = 0;
        k = p;
    
        // Until we reach either end of either L or M, pick larger among
        // elements L and M and place them in the correct position at A[p..r]
        while (i < n1 && j < n2) {
          if (L[i] <= M[j]) {
            arr[k] = L[i];
            i++;
          } else {
            ans[0] += L.length - i;
            arr[k] = M[j];
            j++;
          }
          k++;
        }
    
        // When we run out of elements in either L or M,
        // pick up the remaining elements and put in A[p..r]
        while (i < n1) {
          arr[k] = L[i];
          i++;
          k++;
        }
    
        while (j < n2) {
          arr[k] = M[j];
          j++;
          k++;
        }
  }
    static void mergeSort(long arr[], int l, int r,long[] ans) {
        if (l < r) {
    
          // m is the point where the array is divided into two subarrays
          int m = (l + r) / 2;
    
          mergeSort(arr, l, m,ans);
          mergeSort(arr, m + 1, r,ans);
    
          // Merge the sorted subarrays
          merge(arr, l, m, r,ans);
        }
  }
}