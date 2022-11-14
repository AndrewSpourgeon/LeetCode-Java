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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postOrderList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root != null || !stack.empty()){
            if(root != null){
                stack.push(root);
                root = root.left;
            }
            else{
                    TreeNode temp = stack.peek().right;
                    if(temp == null){
                        temp = stack.peek();
                        stack.pop();
                        postOrderList.add(temp.val);
                        while(!stack.empty() && temp == stack.peek().right){
                            temp = stack.pop();
                            postOrderList.add(temp.val);
                        }
                    }
                    else{
                        root = temp;
                    }
                    
                }
            }
        return postOrderList;
        }
    
    
    
    
    
    
    
    
    

    
//     public List<Integer> postorderTraversal(TreeNode root) {
//         List<Integer> postOrderList = new ArrayList<>();
//         postOrderRecursion(root ,postOrderList);
//         return postOrderList;
//     }
    
//     private void postOrderRecursion(TreeNode root , List<Integer> postorderList){
//         if(root == null){
//             return;
//         }
//         postOrderRecursion(root.left,postorderList);
//         postOrderRecursion(root.right,postorderList);
//         postorderList.add(root.val);

//     }
    
}