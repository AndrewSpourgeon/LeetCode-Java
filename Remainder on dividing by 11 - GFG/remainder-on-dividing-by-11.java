//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
  
        
        int t = Integer.parseInt(br.readLine()); 

        while(t > 0){
  
            String x = br.readLine(); 
            
            Solution ob = new Solution();
		
            System.out.println(ob.xmod11(x)); 

            t--;
        }
    } 
} 



// } Driver Code Ends


//User function Template for Java

class Solution
{ 
    static int xmod11(String x)
	{   
	    //code here
	    int n = x.length();
	    if(n==1) return Integer.valueOf(x);
	    int j = n-1 , i = n-2;
	    int rem = 0;
        while(i >= 0){
            int val = (x.charAt(i)-'0')*10;
            val += x.charAt(j)-'0';
            val += rem;
            rem = val > 99 ? val % 100 : 0;
            rem += val % 11;
            i=i-2;j=j-2;
        }
        if(j == 0){
            int val = x.charAt(0)-'0';
            val += rem;
            return val % 11;
        }
        return rem;
	}
} 

