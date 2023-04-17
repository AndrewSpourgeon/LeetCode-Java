//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        int maxi = 0;
        for(Job j : arr){
            maxi = Math.max(maxi,j.deadline);
        }
        boolean[] dp = new boolean[maxi+1];
        int[] ans = new int[2];
        dp[0] = true;
        Arrays.sort(arr,new Comparator<Job>() {
            public int compare(Job j1, Job j2) {
                return j2.profit-j1.profit;
            }
        });
        for(Job j : arr){
            int index = getSpace(j.deadline,dp);
            if(index != -1){
                ans[0]++;
                dp[index] = true;
                ans[1] += j.profit;
            }
        }
        return ans;
    }
    
    int getSpace(int end , boolean[] dp){
        while(end > 0){
            if(!dp[end]) return end;
            end--;
        }
        return -1;
    }
    
}