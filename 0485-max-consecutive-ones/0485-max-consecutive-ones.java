class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i =0;
        int max =0;
        int count =0;
        while(i<nums.length){
            if(nums[i]==1){
                count = count + 1;
                if(count>max) max = count;
            }
            else{
                count = 0;
            }
            i = i + 1;
        }
        return max;
    }
}