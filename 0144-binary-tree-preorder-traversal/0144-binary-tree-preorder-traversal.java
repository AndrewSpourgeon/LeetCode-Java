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
//     //-> solution 1
//     // recursion
//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> inOrderList = new ArrayList<>();
//         inOrderRecursion(root ,inOrderList);
//         return inOrderList;
//     }
    
//     private void inOrderRecursion(TreeNode root , List<Integer> inorderList){
//         if(root == null){
//             return;
//         }
//         inorderList.add(root.val);
//         inOrderRecursion(root.left,inorderList);
//         inOrderRecursion(root.right,inorderList);
//     }
    
//     //-> solution 2
//     // Iterative
//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> preOrderList = new ArrayList<>();
//         Stack<TreeNode> stack = new Stack<TreeNode>();
//         while(true){
//             if(root != null){
//                 preOrderList.add(root.val);
//                 stack.push(root);
//                 root = root.left;
//             }
//             else{
//                 if(stack.empty()){
//                     break;
//                 }
//                 else{
//                     TreeNode temp = stack.pop();
//                     root = temp.right;
//                 }
//             }
//         }
//         return preOrderList;
//     }
    
    //solution -> 3
    //Morris In-Order Algorithm
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrderList = new ArrayList<>();
        TreeNode cur = root;
        while(cur != null){
            //if cur left is null then add to list and move to right
            if(cur.left == null){
                preOrderList.add(cur.val);
                cur = cur.right;
            }
            //
            else{
                TreeNode temp = cur.left;
                while(temp.right != null && temp.right != cur){
                    temp = temp.right;
                }
                //now we reached end point so create link
                if(temp.right == null){
                    temp.right = cur;
                    preOrderList.add(cur.val);
                    cur = cur.left;
                }
                else{
                    temp.right = null;
                    cur = cur.right;
                }
                
            }
        }
    return preOrderList;
    }
    
}