//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] inputline = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputline[0]);
            inputline = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputline[i]);
            }
            Solution ob =new Solution();
            int[] res = ob.maxOfMin(arr, n);
            
            for (int i = 0; i < n; i++) 
                System.out.print (res[i] + " ");
            System.out.println ();
        }
    }
}
// } Driver Code Ends



class Solution 
{
    //Function to find maximum of minimums of every window size.
    static int[] maxOfMin(int[] a, int n) 
    {
        // Your code here
         int[] ans = new int[n];
        Arrays.fill(ans,Integer.MIN_VALUE);
        Stack<Pair> stack = new Stack<Pair>();
        for(int i = 0 ; i < n ; i++){
            //stack is empty so just push
            if(stack.empty()){
                stack.push(new Pair(a[i],i));
            }
            else{
                //new val is greater than top so just push
                if(a[i] > stack.peek().val){
                    stack.push(new Pair(a[i],i));
                }
                //if new val is smaller than or equal to top
                else{
                    while(!stack.empty() && a[i] <= stack.peek().val){
                        Pair temp = stack.pop();
                        int pse = stack.empty() ? -1 : stack.peek().pos;
                        int index = i - (pse) - 2;
                        if(temp.val > ans[index]){
                           ans[index] = temp.val;
                        }
                    }
                   stack.push(new Pair(a[i],i));  
                }
            }
        }
        //after traversing whole input array and still stack is not empty
        while(!stack.empty()){
            int rightSmallest = n;
            Pair temp = stack.pop();
            int pse = stack.empty() ? -1 : stack.peek().pos;
            int index = rightSmallest - (pse) - 2;
            if(temp.val > ans[index]){
                ans[index] = temp.val;
            }
        }
        int carry = ans[n-1];
        for(int i = n-1 ; i >= 0 ; i--){
            if(ans[i] == Integer.MIN_VALUE || ans[i] < carry){
                ans[i] = carry;
                carry = ans[i];
            }
            else{
                carry = ans[i];
            }
        }      
      return ans;      
    }
}
class Pair {
    int val;
    int pos;
    public Pair(int val,int pos){
        this.val = val;
        this.pos = pos;
    }
}

