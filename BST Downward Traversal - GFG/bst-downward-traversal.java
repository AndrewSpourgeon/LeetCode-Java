//{ Driver Code Starts
//Initial Template for Java
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        PrintWriter out=new PrintWriter(System.out);
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
    	    	int target=Integer.parseInt(br.readLine());
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Solution g = new Solution();
        	    long ans=g.verticallyDownBST(root,target);
        	    out.println(ans);
                t--;
            
        }
        out.close();
    }
  
}




// } Driver Code Ends


//User function Template for Java

class Solution
{
    long verticallyDownBST(Node root,int target)
    {
        Node[] targetNode = new Node[1];
        int[] pos = new int[1];
        searchTarget(root ,pos,0, target , targetNode);
        if(targetNode[0] == null) return -1;
        long ans[] = new long[1];
        findDescendantSum(pos[0],pos[0],ans,targetNode[0]);
        return ans[0] - targetNode[0].data;
    }
    
    private void searchTarget(Node root ,int[] pos,int level, int target ,Node[] targetNode){
        if(root == null) return;
        
        if(root.data == target){
            targetNode[0] = root;
            pos[0] = level;
            return;
        }
        else if(target < root.data){
            searchTarget(root.left ,pos,level-1, target , targetNode);
        }
        else if(target > root.data){
            searchTarget(root.right ,pos,level+1, target , targetNode);
        }
    }
    
    private void findDescendantSum(int targetPos,int curPos,long[] ans,Node root){
        
        if(root == null) return;
        
        if(targetPos == curPos){
            ans[0] += root.data;
        }
        
        findDescendantSum(targetPos,curPos-1,ans,root.left);
        findDescendantSum(targetPos,curPos+1,ans,root.right);
    }
}