class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
        Map<Integer,Integer> dp=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(dp.keySet().contains(target-nums[i])){
                result[0]=dp.get(target-nums[i]);
                result[1]=i;
            }
            else{
                dp.put(nums[i],i);
            }
        }
       return result; 
    }
}