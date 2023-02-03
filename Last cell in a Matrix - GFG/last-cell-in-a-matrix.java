//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split("\\s+");
            int r = Integer.parseInt(str[0]);
            int c = Integer.parseInt(str[1]);
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                int k = 0;
                str = read.readLine().trim().split("\\s+");
                for(int j = 0; j < c; j++){
                  matrix[i][j] = Integer.parseInt(str[k]);
                  k++;
                }
            }
            Solution obj = new Solution();
            int[] p = obj.endPoints(matrix,r,c);
            out.print("(" +  p[0]+ ", " +  p[1]+ ")" +"\n");
        }
        out.close();
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    static int [] endPoints(int [][]matrix, int R, int C){
        //code here
        int[] ans = new int[2];
        HashMap<Character,int[]> oneDir = new HashMap<>();
        HashMap<Character,int[]> zeroDir = new HashMap<>();
        oneDir.put('R',new int[]{1,0,3});
        oneDir.put('L',new int[]{-1,0,20});
        oneDir.put('U',new int[]{0,1,17});
        oneDir.put('D',new int[]{0,-1,11});
        zeroDir.put('R',new int[]{0,1});
        zeroDir.put('L',new int[]{0,-1});
        zeroDir.put('U',new int[]{-1,0});
        zeroDir.put('D',new int[]{1,0});
        int i = 0 , j = 0;
        //System.out.println(zeroDir.get('R')[0]);
        Character prev = 'R';
        while(true){
            if(matrix[i][j] == 0){
                int[] temp = zeroDir.get(prev);
                if(isOutOfBounds(i + temp[0],j + temp[1],R,C)){
                    ans[0] = i;
                    ans[1] = j;
                    break;
                }
                i = i + temp[0];
                j = j + temp[1];
            }
            else{
                matrix[i][j] = 0;
                int[] temp = oneDir.get(prev);
                if(isOutOfBounds(i + temp[0],j + temp[1],R,C)){
                    ans[0] = i;
                    ans[1] = j;
                    break;
                }
                i = i + temp[0];
                j = j + temp[1];
                prev = (char)('A'+temp[2]);
            }
        }
        return ans;
    }
    
    public static boolean isOutOfBounds(int i , int j , int R , int C){
        if(i < 0 || j < 0 || i >= R || j >= C) return true;
        return false;
    }
}