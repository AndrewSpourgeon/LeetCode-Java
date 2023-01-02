/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<Integer,TreeNode> parent = new HashMap<>();
        bfsForParents(root,parent);
        return bfsForNodes(target,k,parent);
    }

    private List<Integer> bfsForNodes(TreeNode target , int k, HashMap<Integer,TreeNode> parent){
        int dist = 0;
        List<Integer> vis = new ArrayList<Integer>();
        vis.add(target.val);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        while(dist < k){
            int size = queue.size();
            for(int i = 1 ; i <= size ; i++){
                TreeNode temp = queue.poll();
                if(temp.left != null && !vis.contains(temp.left.val)){
                    queue.add(temp.left);
                    vis.add(temp.left.val);
                }
                if(temp.right != null && !vis.contains(temp.right.val)){
                    queue.add(temp.right);
                    vis.add(temp.right.val);
                }
                if(parent.get(temp.val) != null && !vis.contains(parent.get(temp.val).val)){
                    queue.add(parent.get(temp.val));
                    vis.add(parent.get(temp.val).val);
                } 
            }
            dist++;
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(TreeNode node : queue){
            ans.add(node.val);
        }
        return ans;
    }

    private void bfsForParents(TreeNode root , HashMap<Integer,TreeNode> parent){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        parent.put(root.val,null);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 1 ; i <= size ; i++){
                TreeNode temp = queue.poll();
                if(temp.left != null){
                    queue.add(temp.left);
                    parent.put(temp.left.val,temp);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                    parent.put(temp.right.val,temp);
                }
            }
        }
    }
}