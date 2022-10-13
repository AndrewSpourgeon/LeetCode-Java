class Solution {
    public int trap(int[] height) {
        if(height.length == 1) return 0;
        int left = 0;
        int right = height.length - 1;
        int rain = 0;
        int lmax = 0;
        int rmax = 0;
        while(left <= right){
            if(height[left] <= height[right]){
                if(height[left] >= lmax) lmax = height[left];
                else rain = rain + (lmax - height[left]);
                left = left + 1;                    
            }
            else{
                if(height[right] >= rmax) rmax = height[right];
                else rain = rain + (rmax - height[right]);
                right = right - 1;                    
            }
        }
        return rain;
    }
}