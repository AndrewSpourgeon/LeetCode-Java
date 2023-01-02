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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int lh = leftHeight(root.left);
        int rh = rightHeight(root.right);
        if(lh == rh){
            return (int)(Math.pow(2,lh+1) - 1);
        }
        else{
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    private int leftHeight(TreeNode root){
        int height = 0;
        while(root != null){
            root = root.left;
            height++;
        }
        return height;
    } 
    private int rightHeight(TreeNode root){
        int height = 0;
        while(root != null){
            root = root.right;
            height++;
        }
        return height;
    }

}