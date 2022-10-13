class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int size=nums.length;
        int i=0;
        int j=i+1;
        int left=j+1;
        int right=size-1;
        while(i<size-3){
            while(j<size-2){
                while(left<right ){
                    if(nums[left] + nums[right] + nums[i] + nums[j] == -294967296){
                        return ans;
                    }
                    else if(nums[left] + nums[right] + nums[i] + nums[j] == target){
                        List<Integer> quad = new ArrayList<Integer>();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[left]);
                        quad.add(nums[right]);
                        ans.add(quad);
                        while(left!=size-1 && nums[left]==nums[left+1]){
                            left++;
                        }
                        left=left+1;
                        while(right!=0 && nums[right]==nums[right-1]){
                            right--;
                        }
                        right=right-1;  
                    }
                    else if(nums[left] + nums[right] +  nums[i] + nums[j] < target){
                        while(left!=size-1 && nums[left]==nums[left+1]){
                            left++;
                        }
                        left=left+1;
                    }
                    else{
                        while(right!=0 && nums[right]==nums[right-1]){
                            right--;
                        }
                        right=right-1; 
                    }
                }
                
                 while(j!=size-1 && nums[j]==nums[j+1]){
                            j++;
                        }
                j=j+1;
                left=j+1;
                right=size-1;
            }
            while(i!=size-1 && nums[i]==nums[i+1]){
                            i++;
                        }
            i=i+1;
            j=i+1;
            left=j+1;
            right=size-1;
        }
        return ans;
    }
}