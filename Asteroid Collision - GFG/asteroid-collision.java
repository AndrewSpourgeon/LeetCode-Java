//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] asteroids = new int[N];
            for (int i = 0; i < N; i++) asteroids[i] = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.asteroidCollision(N, asteroids);

            for (int e : res) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int[] asteroidCollision(int n, int[] ast) {
        // code here
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0 ; i < n ; i++){
            if(stack.empty()){
                stack.push(ast[i]);
            }
            //collision happens
            else if(ast[i] < 0 && stack.peek() > 0){
            
                if(Math.abs(ast[i]) > stack.peek()){
                    while(!stack.empty() && 
                     ast[i] < 0 && stack.peek() > 0 && Math.abs(ast[i]) > stack.peek()){
                        stack.pop();
                    }
                    if(!stack.empty() && ast[i] < 0 && stack.peek() > 0 && Math.abs(ast[i]) < stack.peek()){
                        continue;
                    }
                    if(!stack.empty() && ast[i] < 0 && stack.peek() > 0 && Math.abs(ast[i]) == stack.peek()){
                        stack.pop();
                        continue;
                    }
                    stack.push(ast[i]);
                }
                
                else if(Math.abs(ast[i]) == stack.peek()){
                    stack.pop();
                }
                
            
            }
            else if((ast[i] > 0 && stack.peek() > 0) || (ast[i] > 0 && stack.peek() < 0) || (ast[i] < 0 && stack.peek() < 0)){
                stack.push(ast[i]);
            }
        }
        int len = stack.size();
        int[] ans = new int[len];
        Arrays.fill(ans,-1);
        for(int i = len-1 ; i >= 0 ; i--){
            ans[i] = stack.pop();
        }
        return ans;
    }
}
