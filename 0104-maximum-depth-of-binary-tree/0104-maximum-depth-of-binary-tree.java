/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int height = 0;
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(root,1));
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 1 ; i <= size ; i++){
                Pair temp = queue.poll();
                if(temp.node.left != null){
                  queue.add(new Pair(temp.node.left,temp.level + 1));  
                } 
                if(temp.node.right != null){
                  queue.add(new Pair(temp.node.right, temp.level + 1));  
                } 
                if(temp.level > height){
                    height = temp.level;
                }
            }
            
        }
        return height;
    }
}
class Pair{
    TreeNode node;
    int level;
    public Pair(TreeNode node , int level){
        this.node = node;
        this.level = level;
    }
}