class Solution {
    public boolean isAnagram(String s, String t) {
        int m = s.length();
        int n = t.length();
        if(m != n) return false;
        int[] char_counts = new int[26];
        for(int i = 0 ; i < m ; i++){
            char_counts[s.charAt(i) - 'a']++;
            char_counts[t.charAt(i) - 'a']--;
        }
        
        for(int val : char_counts){
            if(val != 0) return false;
        }
        
        return true;
    }
}