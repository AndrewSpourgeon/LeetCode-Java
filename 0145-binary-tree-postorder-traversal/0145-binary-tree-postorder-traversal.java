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
//     public List<Integer> postorderTraversal(TreeNode root) {
//         List<Integer> postOrderList = new ArrayList<>();
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
//                     TreeNode temp = stack.peek();
//                     if(temp.right == null || postOrderList.contains(temp.right.val)){
//                         stack.pop();
//                         postOrderList.add(temp.val);
//                         root = null;
//                     }
//                     else{
//                         root = temp.right;
//                     }
                    
//                 }
//             }
//         return postOrderList;
//         }
    
    
    
    
    
    
    
    
    

    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postOrderList = new ArrayList<>();
        postOrderRecursion(root ,postOrderList);
        return postOrderList;
    }
    
    private void postOrderRecursion(TreeNode root , List<Integer> postorderList){
        if(root == null){
            return;
        }
        postOrderRecursion(root.left,postorderList);
        postOrderRecursion(root.right,postorderList);
        postorderList.add(root.val);

    }
    
}