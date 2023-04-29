//{ Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution{
public:
    long long findNumber(long long N){
        // Code here
        // Code here
        /*

      if unable to understand the below text look at the image and refer the code for arrray reference of 9,1,3,5,7

       suppose 529th number vs 530th number
        
        
        529th number
        
        529%5=4= at 4th index we have 7 this wil be unit digit
        
                    N    num    ans   
iteration 1        529     1    0
                                ans=ans+num*val[N%5] = 0+1*(val[529%5]=0+1*val[4]=7
                   N=N/5=105
                           num=num*10=1*10=10
                   
iteration 2 
                  105     10    7
                                ans=7+10*val[105%5]=7+10*9=97
                  N=N/5=21-1=20 as 105%5==0
                          num=num*10=100
                          
iteration 3
                  20      100   97
                                ans=97+10*val[20%5]=97+10*val[0]=97+9*100=997
                N=N/5=4-1=3 // as 20 %5 =0
                            num=num*10=1000

same wa iteration 4
                  3      1000   997
                we wil gett final result
                  0      10000  5997
                    
        530th number
        
        */
        long long ans=0,num=1;
        
        vector<int> val={9,1,3,5,7};
        
        while(N)
        {
            ans+=val[N%5]*num;
            
            if(N%5==0)
                N=(N/5)-1;
            else
                N=N/5;
                
            num=num*10;
        }
        
        return ans;
    
    }
};

//{ Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        long long N;
        cin>>N;
        Solution ob;
        cout<<ob.findNumber(N)<<endl;
    }
    return 0;
}
// } Driver Code Ends