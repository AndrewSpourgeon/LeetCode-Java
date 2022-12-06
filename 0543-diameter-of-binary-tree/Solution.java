class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        findDiameter(root,diameter);
        return diameter[0];
    }
    
    private int findDiameter(TreeNode root , int[] diameter){
        if(root == null) return 0;
        
        int lh = findDiameter(root.left,diameter);
        int rh = findDiameter(root.right,diameter);
        diameter[0] = Math.max(diameter[0] , lh+rh);
        return 1 + Math.max(lh,rh);
    }
}
