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
    public int widthOfBinaryTree(TreeNode root) {
        int width = 0;
        Deque<Pair> dp = new ArrayDeque<Pair>();
        dp.addLast(new Pair(root,1));
        while(!dp.isEmpty()){
            int size = dp.size();
            width = Math.max((dp.getLast().index - dp.getFirst().index + 1),width);
            for(int i = 1 ; i <= size ; i++){
                Pair temp = dp.pollFirst();
                if(temp.node.left != null) dp.addLast(new Pair(temp.node.left,(temp.index*2)));
                if(temp.node.right != null) dp.addLast(new Pair(temp.node.right,(temp.index*2)+1));
            }
        }
        return width;
    }
    
}
class Pair{
    TreeNode node;
    int index;
    public Pair(TreeNode node,int index){
        this.node = node;
        this.index = index;
    }
}