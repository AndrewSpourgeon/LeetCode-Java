//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int A =sc.nextInt();
            int B =sc.nextInt();
            int C =sc.nextInt();
            int D =sc.nextInt();
             
           System.out.println(new Solution().carpetBox(A,B,C,D)); 
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution{
    int carpetBox(int a, int b, int c, int d) { 
        //code here
        int count = 0;
        int carpMin = Math.min(a,b);
        int carpMax = Math.max(a,b);
        int boxMin = Math.min(c,d);
        int boxMax = Math.max(c,d);
        if(carpMax < boxMin) return 0;
        while(carpMin > boxMin || carpMax > boxMax){
            if(carpMax > boxMax){
                int temp = (int) Math.floor(carpMax/2);
                if(temp > carpMin){
                    carpMax = temp;
            }
                else{
                    carpMax = carpMin;
                    carpMin = temp;
                }
            }
            else if(carpMin > boxMin){
                int temp = (int) Math.floor(carpMin/2);
                carpMin = temp;
            }
            count++;
        }
        return count;
    }
   
}
