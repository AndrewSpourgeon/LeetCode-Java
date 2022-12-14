//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String str = br.readLine().trim();

            Vector<Integer> ans = new Solve().findRange(str, n);
            if (ans.size() == 1) {
                System.out.println(ans.get(0));
            } else {
                System.out.println(ans.get(0) + " " + ans.get(1));
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solve {

    Vector<Integer> findRange(String str, int n) {
        // code here
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        int temp = 0;
        int start = 0;
        int tempstr = 0;
        int end = 0;
        int zeroes = 0;
        for(char c : str.toCharArray()){
            if(c == '0'){
                zeroes = 1;
                break;
            }
        }
        if(zeroes == 0){
            return new Vector<Integer>(Arrays.asList(-1));
        }
        for(int i = 0 ; i < n ; i++){
            sum += str.charAt(i) == '1' ? -1 : 1;
            if(sum > maxi){
                maxi = sum;
                start = tempstr;
                end = i;
            }
            if(sum < 0){
                sum = 0;
                tempstr = i + 1;
            }
        }
        
        Vector<Integer> ans = new Vector<Integer>();
        ans.add(start+1);
        ans.add(end+1);
        return ans;
    }
}