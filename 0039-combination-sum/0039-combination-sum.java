class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        combos(0,target,candidates,ans,new ArrayList<>());
        return ans;
    }
    
    public void combos(int index , int target , int[] persons , List<List<Integer>> dp , List<Integer> temp)
    {
        if(index == persons.length ){
            if(target == 0){
            dp.add(new ArrayList<>(temp));
            }
            return;
        }
        
        if(persons[index] <= target){
            temp.add(persons[index]);
            combos(index,target-persons[index],persons,dp,temp);
            temp.remove(temp.size()-1);
        }
        combos(index+1,target,persons,dp,temp);
    }
}