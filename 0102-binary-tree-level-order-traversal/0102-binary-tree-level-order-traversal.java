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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<List<Integer>>();
        List<List<Integer>> bfs = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> dp = new ArrayList<Integer>();
            for(int i = 1 ; i <= size ; i++){
                TreeNode temp = queue.poll();
                if(temp.left != null){
                  queue.add(temp.left);  
                } 
                if(temp.right != null){
                  queue.add(temp.right);  
                } 
                dp.add(temp.val);  
            }
            bfs.add(dp);
        }
        return bfs;
    }
}