class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> dp = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            dp.add(nums[i]);
        }
        int max=0;
        boolean contains = true;
        for(int i=0;i<nums.length;i++){
            int count=0;
            if(!dp.contains(nums[i]-1)){
                do{
                    count = count + 1;
                }while(dp.contains(nums[i]+count));
            }
            if(count>max){
                max=count;
            }
            
        }
        return max;
    }
}