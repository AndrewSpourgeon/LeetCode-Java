//{ Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution{  
private:
 int dr[4]={1,0,-1,0};
 int dc[4]={0,-1,0,1};
 bool isvalid(int row , int col, int N, int M){
     return(row>=0 && row<N && col>=0 && col<M);
 }
void dfsSolve(int row,int col, vector<vector<bool>>&vis,vector<vector<int>> &mat, int &N, int &M){
       vis[row][col]= true;
       int val = mat[row][col]; 
       for(int i=0;i<4;i++){
           int nrow = row + dr[i];
           int ncol = col + dc[i];
           if(isvalid(nrow,ncol,N,M) && !vis[nrow][ncol] && mat[nrow][ncol]>=val ){
               dfsSolve(nrow,ncol,vis,mat,N,M);
           }
       }
}    

public:
    int water_flow(vector<vector<int>> &mat,int N,int M){
    // Write your code here.
    vector<vector<bool>>indianVis(N,vector<bool>(M,false));
    vector<vector<bool>>arabVis(N,vector<bool>(M,false));
      for(int i=0;i<N;i++) dfsSolve(i,0,indianVis,mat,N,M);
      for(int j=0;j<M;j++) dfsSolve(0,j,indianVis,mat,N,M);
      for(int i=0;i<N;i++) dfsSolve(i,M-1,arabVis,mat,N,M);
      for(int j=0;j<M;j++) dfsSolve(N-1,j,arabVis,mat,N,M);
       int ans=0;
       for(int i=0;i<N;i++){
           for(int j=0;j<M;j++){
               if(indianVis[i][j] && arabVis[i][j])ans++;
           }
       }
     return ans;
    }
};



//{ Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int n,m;
        cin>>n>>m;
        vector<vector<int>> mat(n, vector<int>(m));
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                cin>>mat[i][j];
            }
        }
        Solution ob;
        cout << ob.water_flow(mat, n, m) << endl;
        
    }
}


// } Driver Code Ends