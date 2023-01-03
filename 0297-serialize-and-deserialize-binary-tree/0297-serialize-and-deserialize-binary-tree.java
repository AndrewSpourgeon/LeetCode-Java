/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String s = "";
        if(root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.add(root);
            s = s + Integer.toString(root.val) + " ";
        }
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i = 1 ; i <= len ; i++){
                TreeNode temp = queue.poll();
                if(temp.left != null){
                    queue.add(temp.left);
                    s = s + Integer.toString(temp.left.val) + " ";
                }
                if(temp.left == null){
                    s = s + "N" + " ";
                }
                if(temp.right != null){
                    queue.add(temp.right);
                    s = s + Integer.toString(temp.right.val) + " ";
                }
                if(temp.right == null){
                    s = s + "N" + " ";
                }
            }
        }
        return s;

    }

    // Decodes your encoded data to tree.
    //123NN45NNNN
    public TreeNode deserialize(String s) {
        int len = s.length();
        if(len == 0) return null;
        int k = 0;
        String[] splitted = s.split("\\s+");
        ArrayList<String> data = new ArrayList<String>(Arrays.asList(splitted));
        TreeNode root = new TreeNode(Integer.parseInt(data.get(0)));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int arrSize = data.size();
        int iter = 1;
        while(iter < arrSize && !queue.isEmpty()){
            int i = queue.size();
            for(int j = 1 ; j <= i ; j++){
                TreeNode temp = queue.poll();
                boolean leftTaken = false;
                boolean rightTaken = false;
                if( iter < arrSize && data.get(iter).equals("N")){
                    temp.left = null;
                    iter++;
                    leftTaken = true;
                }
                if(!leftTaken && iter < arrSize && !data.get(iter).equals("N")){
                    temp.left = new TreeNode(Integer.parseInt(data.get(iter)));
                    queue.add(temp.left);
                    iter++;
                }
                if(iter < arrSize && data.get(iter).equals("N")){
                    temp.right = null;
                    iter++;
                    rightTaken = true;
                }
                if(!rightTaken && iter < arrSize && !data.get(iter).equals("N")){
                    temp.right = new TreeNode(Integer.parseInt(data.get(iter)));
                    queue.add(temp.right);
                    iter++;
                }
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));