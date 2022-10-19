class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dp = new ArrayDeque<Integer>();
        int len = nums.length;
        int range = 0;
        int[] ans = new int[len - k + 1];
        
        while(range < k){
            if(dp.size() == 0 || nums[range] <= nums[dp.getLast()]){
                dp.addLast(range);
            }
            else{
                while(dp.size() != 0 && nums[dp.getLast()] < nums[range]){
                    dp.pollLast();
                }
                dp.addLast(range);
            }
            range = range + 1;
        }
        int j = 0;
        ans[j] = nums[dp.getFirst()];
        for(int i = k ; i < len ; i++ ){
            while(dp.size() != 0 && dp.getFirst() < (i-k+1)){
                dp.pollFirst();
            }
            if(dp.size() == 0 || nums[i] <= nums[dp.getLast()]){
                dp.addLast(i);
            }
            else{
                while(dp.size() != 0 && nums[dp.getLast()] < nums[i]){
                    dp.pollLast();
                }
                dp.addLast(i);
            }
            j = j + 1;
            ans[j] = nums[dp.getFirst()];
        }
        return ans;
    }
}