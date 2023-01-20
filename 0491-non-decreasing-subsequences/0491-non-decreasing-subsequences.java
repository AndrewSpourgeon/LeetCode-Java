class Solution {
    HashSet<List<Integer>> set = new HashSet<List<Integer>>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            solve(i,-101,0,true,new ArrayList<Integer>(),nums,n);
        }
        List<List<Integer>> ans = new ArrayList<List<Integer>>(set);
        return ans;
    }

    private void solve(int index , int prev , int count , boolean picked , List<Integer> temp , int[] nums , int n){
        if(count > 1 && picked){
            set.add(new ArrayList<>(temp));
        }
        if(index == n) return;

        if(prev <= nums[index]){
            temp.add(nums[index]);
            solve(index+1,nums[index],count+1,true,temp,nums,n);
            temp.remove(temp.size()-1);
            solve(index+1,prev,count,false,temp,nums,n);
        }
        else{
            solve(index+1,prev,count,false,temp,nums,n);
        }
    }
}