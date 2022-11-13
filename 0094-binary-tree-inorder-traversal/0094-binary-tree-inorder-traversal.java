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
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> inOrderList = new ArrayList<>();
//         inOrderRecursion(root ,inOrderList);
//         return inOrderList;
//     }
    
//     private void inOrderRecursion(TreeNode root , List<Integer> inorderList){
//         if(root == null){
//             return;
//         }
//         inOrderRecursion(root.left,inorderList);
//         inorderList.add(root.val);
//         inOrderRecursion(root.right,inorderList);
//     }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inOrderList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(true){
            if(root != null){
                stack.push(root);
                root = root.left;
            }
            else{
                if(stack.empty()){
                    break;
                }
                TreeNode temp = stack.pop();
                inOrderList.add(temp.val);
                root = temp.right;
            }
        }
        return inOrderList;
    }
    
    
}