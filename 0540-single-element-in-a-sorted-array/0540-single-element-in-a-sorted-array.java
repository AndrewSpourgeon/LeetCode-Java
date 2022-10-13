class Solution {
    public int singleNonDuplicate(int[] nums) {
       int low = 0;
       int high = nums.length-2;
        while(low <= high){
            int mid = (low+high)/2;
            //mid is even
            if(mid % 2 == 0){
                //left-half
                if(nums[mid] == nums[mid+1]){
                    low = mid+1;
                }
                //right-half
                else{
                    high = mid-1;
                }
            }
            //mid is odd
            else{
                //right-half
               if(nums[mid] == nums[mid+1]){
                    high = mid-1;
                }
                //left-half
                else{
                    low = mid+1;
                } 
            }
        }
        return nums[low];
    }
}