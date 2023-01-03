//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] H = new int[N];
            
            for(int i=0; i<N; i++)
                H[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.removeStudents(H,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
// 10
// 7 5 6 4 8 1 3 8 3 9
class Solution {
    public int removeStudents(int[] nums, int n) {
        // code here
        ArrayList<Integer> dp = new ArrayList<Integer>();
        for(int i = 0 ; i < n ; i++){
            if(dp.isEmpty()){
                dp.add(nums[i]);
            }
            else{
                int index = solve(dp,nums[i]);
                if(index < dp.size()){
                    dp.set(index,nums[i]);
                }
                else{
                    dp.add(nums[i]);
                }
            }
            
        }
        return n - dp.size();
    }
    private int solve(ArrayList<Integer> dp,int val){
        int low = 0;
        int high = dp.size()-1;
        while(low <= high){
            int mid = (low+high)/2;
            if(dp.get(mid) == val){
                return mid;
            }
            else if(dp.get(mid) < val){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return low;
    }
    
};