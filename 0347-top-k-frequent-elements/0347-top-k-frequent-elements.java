class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freq = new HashMap<Integer,Integer>();
        for(int i =0 ; i < nums.length ; i++){
            if(freq.keySet().contains(nums[i])){
                freq.put( nums[i], freq.get(nums[i]) + 1);
            }
            else{
                freq.put( nums[i], 1);
            }
        }
        return getKeys(freq,k);
    }
    
    public int[] getKeys(Map<Integer,Integer> freq, int k){
        List<Integer> temp = new ArrayList<Integer>(); 
        for(int m =1; m <= k ;m++){
            int val = (Collections.max(freq.entrySet(),(entry1,entry2) -> entry1.getValue() - entry2.getValue()).getKey());
            temp.add(val);
            freq.remove(val);
        }
        
        int[] keys = new int[temp.size()];
        int j =0;
        for(int i : temp){
           keys[j] = i;
           j = j + 1;
        }
        return keys;
    }
}