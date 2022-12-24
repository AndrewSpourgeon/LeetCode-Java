//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0)
        {
            int N = sc.nextInt();
            int arr[] = new int[N];
            for(int i=0; i<N; i++)
                arr[i] = sc.nextInt();
            
            Solution g = new Solution();
            long ans = g.wineSelling(arr,N);
            
            System.out.println(ans);
            T--;
        }
    }
}


// } Driver Code Ends
//User function Template for Java


class Solution {
    long wineSelling(int nums[],int n){
        // code here
        long ans = 0L;
        Stack<Pair> stack = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            if(stack.empty()){
                stack.push(new Pair(nums[i],i));
            }
            else{
                Pair temp = stack.peek();
                int cur = nums[i];
                if(cur > 0 && temp.val > 0){
                    stack.push(new Pair(cur,i));
                    continue;
                }
                if(cur < 0 && temp.val < 0){
                    stack.push(new Pair(cur,i));
                    continue;
                }
                //I can buy wine
                if(cur > 0 && temp.val < 0){
                    while(!stack.empty() && cur > 0 && stack.peek().val < 0){
                        if(Math.abs(stack.peek().val) <= cur){
                            ans +=  (Math.abs(stack.peek().val))*(Math.abs(stack.peek().index-i));
                            cur = cur + stack.pop().val;
                        }
                        else if(Math.abs(stack.peek().val) > cur){
                            ans += (Math.min(Math.abs(stack.peek().val),cur))*(Math.abs(stack.peek().index-i));
                            Pair top = stack.pop();
                            stack.push(new Pair(top.val+cur,top.index));
                            cur = 0;
                        }
                    }
                    if(cur != 0){
                        stack.push(new Pair(cur,i));
                    }
                }
                //I can sell wine
                else if(cur < 0 && temp.val > 0){
                    while(!stack.empty() && cur < 0 && stack.peek().val > 0){
                        if(Math.abs(cur) <= stack.peek().val){
                            ans +=  (Math.abs(cur))*(Math.abs(stack.peek().index-i));
                            Pair top = stack.pop();
                            if(top.val+cur != 0){
                                stack.push(new Pair(top.val+cur,top.index));
                            }
                            cur = 0;
                        }
                        else if(Math.abs(cur) > stack.peek().val){
                            ans += (Math.min(Math.abs(cur),stack.peek().val))*(Math.abs(stack.peek().index-i));
                            Pair top = stack.pop();
                            cur = cur + top.val;
                            
                        }
                    }
                    if(cur != 0){
                        stack.push(new Pair(cur,i));
                    }
                    
                }
                
                
            }
        } 
        return ans;
    }
}
class Pair{
    int val;
    int index;
    public Pair(int val,int index){
        this.val = val;
        this.index = index;
    }
}

//{ Driver Code Starts.
// } Driver Code Ends