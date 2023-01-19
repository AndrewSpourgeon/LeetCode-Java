class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int preRem = 0;
        int[] mods = new int[k];
        mods[0] = 1;
        for(int val : nums){
            preRem = (preRem + val % k + k) % k;
            count += mods[preRem];
            mods[preRem]++;
        }
        return count;
    }
}