//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java

class Solution
{
    int[] prime;
    Solution()
    {
        // Every index of prime stores zero or one
        // If prime[i] is zero means i is not a prime
        // If prime[i] is one means i is a prime
    }
    
    public int shortestPath(int Num1,int Num2){
        // Complete this function using prime array
        int l = Num1 , r = Num2;
        if(l==r) return 0;
        prime = new int[10000];
        Arrays.fill(prime,1);
	    for(int i = 2 ; i*i <= 10000 ; i++){
	        if(prime[i] == 1){
	            for(int j = i*i ; j < 10000 ; j = j + i){
	                prime[j] = 0;
	            }
	        }
	    }
	   for(int i = 0 ; i < 1000 ; i++) prime[i] = 0;
	    Queue<int[]> queue = new LinkedList<>();
	    queue.add(new int[]{l,0});
	    int[] vis = new int[10000];
	    vis[l] = 1;
	    while(!queue.isEmpty()){
	        int[] temp = queue.poll();
	        if(temp[0] == r) return temp[1];
	        for(int i = 1 ; i <= 1000 ; i *= 10){
	            for(int j = 0 ; j <= 9 ; j++){
	                int comb = temp[0]/(i*10)*(i*10)+(j*i)+temp[0]%i;
	                if(prime[comb] == 1 && vis[comb] == 0){
	                    vis[comb] = 1;
	                    queue.add(new int[]{comb,temp[1]+1});
	                }
	            }
	        }
	    }
	   
	    

        
	    return -1;
    }
}

//{ Driver Code Starts.
class GFG{
    public static void main(String args[]) throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        Solution ob = new Solution();
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int Num1=Integer.parseInt(input_line[0]);
            int Num2=Integer.parseInt(input_line[1]);
            System.out.println(ob.shortestPath(Num1,Num2));
        }
    }
}
// } Driver Code Ends