class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        int left=0;
        int right=0;
        Map<Character,Integer> temp=new HashMap<Character,Integer>();
        char[] chars=s.toCharArray();
        
        //core
        
        while(right < chars.length)
        {
            if(temp.keySet().contains(chars[right])){
                
                if(temp.get(chars[right])>=left && temp.get(chars[right])<=right){
                    left = temp.get(chars[right]) + 1;
                }
                if((right-left) + 1 > max){
                    max = (right-left) + 1;
                }
                temp.put(chars[right],right);
            }
            else{
                temp.put(chars[right],right);
                if((right-left) + 1 > max){
                    max = (right-left) + 1;
                }
            }
            right=right+1;
        }        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        return max;
        
    }
}