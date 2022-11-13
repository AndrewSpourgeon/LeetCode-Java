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
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> inOrderList = new ArrayList<>();
        inOrderRecursion(root ,inOrderList);
        return inOrderList;
    }
    
    private void inOrderRecursion(TreeNode root , List<Integer> inorderList){
        if(root == null){
            return;
        }
        inorderList.add(root.val);
        inOrderRecursion(root.left,inorderList);
        inOrderRecursion(root.right,inorderList);
    }
    
}