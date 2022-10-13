import java.math.BigInteger;
class Solution {
    
   // using dynamic programming with recursion
     public int uniquePaths(int m, int n) {
//         int[][] dp=new int[m][n];
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 dp[i][j] = -1;
//             }
//         }
//         return countPaths(0,0,m,n,dp);
//     }
//     public static int countPaths(int i,int j,int m,int n,int[][] dp){
//         if(i>=m || j>=n ) return 0;
//         else if(i==m-1 && j==n-1) return 1;
//         else if(dp[i][j] != -1) return dp[i][j];
//         else {
//           return dp[i][j] = countPaths(i+1,j,m,n,dp) + countPaths(i,j+1,m,n,dp);
//         }
        
        
        //using combinatorics
       long N=m+n-2;
       long r=m-1;
       long ans=1;
       for(long i=1;i<=r;i++){
            ans=ans*(N-r+i)/i;
       }
         Long l=new Long(ans);
         return l.intValue();
        
    }
}