class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        combos(0,target,candidates,new ArrayList<Integer>(),ans);
        return ans;
    }
    
    public void combos(int index , int target , int[] candidates , List<Integer> temp , List<List<Integer>> ans){
            if(target == 0){
                ans.add(new ArrayList<Integer>(temp));
                return;
            }
        
        
        for(int i=index; i<candidates.length;i++){
            if(i > index && candidates[i] == candidates[i-1]) continue;
            if(candidates[i] > target) break;
            temp.add(candidates[i]);
            combos(i+1 , target-candidates[i] , candidates , temp , ans);
            temp.remove(temp.size()-1);
            
        }
        
    }
}