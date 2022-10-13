class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int a=0;
        int low=a+1;
        int high=nums.length-1;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        while(a <= nums.length-3){
            while(low < high){
                if(nums[a]+nums[low]+nums[high] == 0){
                    List<Integer> dp = new ArrayList<Integer>();
                    dp.add(nums[a]);
                    dp.add(nums[low]);
                    dp.add(nums[high]);
                    ans.add(dp);
                    while(low < nums.length-1 && nums[low] == nums[low+1]){
                        low = low + 1;
                    }
                    low = low + 1;
                }
                
                else if(nums[a]+nums[low]+nums[high] < 0){
                    while(low < nums.length-1 && nums[low] == nums[low+1]){
                        low = low + 1;
                    }
                    low = low + 1;
                }
                
                else{
                    while(high > 0 && nums[high] == nums[high-1]){
                        high = high - 1;
                    }
                    high = high - 1;
                }
            }
            
            while(a < nums.length-1 && nums[a] == nums[a+1]){
                a = a + 1;
            }
            a = a + 1;
            low = a + 1;
            high = nums.length - 1;
        }
        return ans;
    }
}