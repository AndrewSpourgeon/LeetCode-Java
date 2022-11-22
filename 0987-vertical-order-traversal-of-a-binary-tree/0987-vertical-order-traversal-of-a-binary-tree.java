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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Triple> queue = new LinkedList<Triple>();
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>>();
        queue.add(new Triple(root,0,0));
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ; i < size ; i++){
                Triple temp = queue.poll();
                //add its childs to queue
                if(temp.node.left != null) queue.add(new Triple(temp.node.left,temp.width-1, temp.depth+1));
                if(temp.node.right != null) queue.add(new Triple(temp.node.right,temp.width+1,temp.depth+1 ));
                //now add to tree map
                int x = temp.width;//0
                int y = temp.depth;//2
                if(map.keySet().contains(x)){
                    TreeMap<Integer,PriorityQueue<Integer>> tempTree = map.get(x);
                    if(tempTree.keySet().contains(y)){
                        PriorityQueue<Integer> heap = tempTree.get(y);
                        heap.add(temp.node.val);
                        tempTree.put(y,heap);
                        map.put(x,tempTree);
                    }
                    else{
                        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
                        heap.add(temp.node.val);
                        tempTree.put(y,heap);
                        map.put(x,tempTree);
                    }
                    
                }
                else{
                    TreeMap<Integer,PriorityQueue<Integer>> innerTree = new TreeMap<Integer,PriorityQueue<Integer>>();
                    PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
                    heap.add(temp.node.val);
                    innerTree.put(y,heap);
                    map.put(x,innerTree);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for(Map.Entry<Integer,TreeMap<Integer,PriorityQueue<Integer>>> entry1 : map.entrySet()){
            TreeMap<Integer,PriorityQueue<Integer>> entry2 = entry1.getValue();
            List<Integer> list = new ArrayList<Integer>();
            for(Map.Entry<Integer,PriorityQueue<Integer>> entry3 : entry2.entrySet()){
                PriorityQueue<Integer> entry4 = entry3.getValue();
                while(!entry4.isEmpty()){
                    list.add(entry4.poll());
                } 
            }
            ans.add(list);
        }
        return ans;
    }
}

class Triple{
    TreeNode node;
    int width;
    int depth;
    public Triple(TreeNode node , int width , int depth){
        this.node = node;
        this.width = width;
        this.depth = depth;
    }
}