class Solution {
    public int search(int[] nums, int target) {
        int ans = -1;
        int low = 0;
        int high = nums.length-1;
        int bp = nums.length;
        
        //finding break point 
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] > nums[i+1]) 
            {
                bp = i+1;
                break;
            }
        }
        
        //finding range for binary search
        if(target == nums[0]){
            return 0;
        }
        else if(target < nums[0]){
            low = bp ;
        }
        else{
            high = bp - 1;
        }
        
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] == target){
                ans = mid;
                break;
            }
            else if(nums[mid] > target){
                high = mid-1;
            }
            else{
                low = mid + 1;
            }
        }
        
       return ans; 
    }
}