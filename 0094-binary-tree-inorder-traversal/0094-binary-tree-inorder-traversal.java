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
    
//     //-> Solution 1
//     //Recursion
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
    
//     //-> Solution 2
//     // Iterative
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> inOrderList = new ArrayList<>();
//         Stack<TreeNode> stack = new Stack<TreeNode>();
//         while(true){
//             if(root != null){
//                 stack.push(root);
//                 root = root.left;
//             }
//             else{
//                 if(stack.empty()){
//                     break;
//                 }
//                 TreeNode temp = stack.pop();
//                 inOrderList.add(temp.val);
//                 root = temp.right;
//             }
//         }
//         return inOrderList;
//     }
    //solution -> 3
    //Morris In-Order Algorithm
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inOrderList = new ArrayList<>();
        TreeNode cur = root;
        while(cur != null){
            //if cur left is null then add to list and move to right
            if(cur.left == null){
                inOrderList.add(cur.val);
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
                    cur = cur.left;
                }
                else{
                    inOrderList.add(cur.val);
                    temp.right = null;
                    cur = cur.right;
                }
                
            }
        }
    return inOrderList;
    }
}