class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        ans.add(new ArrayList<Integer>());
        for(int n : nums){
            int size = ans.size();
            for(int i =0 ; i < size ; i++){
                List<Integer> sub = new ArrayList<Integer>(ans.get(i));
                sub.add(n);
                ans.add(sub);
            }
        }
        return ans;
    }
}