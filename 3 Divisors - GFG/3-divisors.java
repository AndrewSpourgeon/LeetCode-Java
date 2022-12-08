//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int q = sc.nextInt();
            ArrayList<Long> query = new ArrayList<>();
            for(int i=0;i<q;i++){
                query.add(sc.nextLong());
            }
            Solution ob = new Solution();
                
            ArrayList<Integer> ans = ob.threeDivisors(query,q);
            for(int cnt : ans) {
                System.out.println(cnt);
            }
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static ArrayList<Integer> threeDivisors(ArrayList<Long> query, int q){
        // code here
        int[] primes = new int[1000001];
        producePrimes(primes);
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i = 0 ; i < q ; i++){
            int count = 0;
            long val = query.get(i);
            for(long j = 1L ; j <= val ; j++){
                double temp = Math.sqrt(j);
                if((int)temp == temp && primes[(int)temp] == 1) count++;
            }
            ans.add(count);
        }
        
        return ans;
    }
    static void producePrimes(int[] primes){
            Arrays.fill(primes,1);
            primes[0] = 0;
            primes[1] = 0;
            for(int p = 2 ; p*p < 1000001 ; p++){
                if(primes[p] == 1){
                    for(int i = p*p ; i < 1000001 ; i = i + p){
                        primes[i] = 0;
                    }
                }
            }
        }
        
    
    
    // static ArrayList<Integer> threeDivisors(ArrayList<Long> query, int q){
    //     // code here
    //     ArrayList<Integer> prime = primeNumber(1000000);
    //     ArrayList<Integer> ans = new ArrayList<>();
    //     for(long q1 : query) {
    //         ans.add(solve(prime,q1));
    //     }
    //     return ans;
    // }
    
    // public static ArrayList<Integer> primeNumber(int n) {
    //     int[] prime = new int[n+1];
    //     Arrays.fill(prime,1);
    //     prime[0]=0;
    //     prime[1]=0;
        
    //     for(int i=2;i<=n;i++) {
    //         if(prime[i]==1) {
    //             for(int j=i+i;j<=n;j+=i) {
    //                 prime[j]=0;
    //             }
    //         }
    //     }
    //     ArrayList<Integer> list = new ArrayList<>();
    //     for(int i=0;i<=n;i++) {
    //         if(prime[i]==1) list.add(i);
    //     }
    //     return list;
    // }
    
    // public static int solve(ArrayList<Integer> prime,long q) {
    //     int v1 = (int)Math.sqrt(q);
    //     int lo=0,hi=prime.size()-1;
    //     int ans=0;
    //     while(lo<=hi) {
    //         int mid = lo+(hi-lo)/2;
    //         if(prime.get(mid)<=v1) {
    //             lo=mid+1;
    //             ans = Math.max(ans,mid+1);
    //         } else {
    //             hi=mid-1;
    //         }
    //     }
    //     return ans;
    // }
    
    
    
    
    
}