
class Solution {
    public int removeDuplicates(int[] nums) {
    //    int i=0;
    //    int j=1;
    // int count=1;
    //     while(j<nums.length || i<nums.length){
    //         if(nums[i]==nums[j]){
    //             j++;
    //         }
    //         else if(nums[i]<nums[j]){
    //             nums[i+1]=nums[j];
    //             i++;
    //             count++;
    //         }
    //     }
    //     return count;
        
        
        
        
        if(nums.length == 1) return nums.length;
        
        int i =0;
        int j = 1;
        
        while(j < nums.length){
            if(nums[i] != nums[j]){
                i = i + 1;
                j = j + 1;
            }
            else{
               while(j<nums.length-1 && nums[j]==nums[j+1]){
                   j = j + 1;
               } 
                j = j + 1;
                if(j<nums.length){
                nums[i + 1] = nums[j];
                i = i + 1;
                }
            }   
        }
    
        return i+1; 
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
       
    }
}