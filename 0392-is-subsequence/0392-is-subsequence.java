class Solution {
    public boolean isSubsequence(String s, String t) {
        int sLen = s.length()-1;
        int tLen = t.length()-1;
        while(sLen >= 0 && tLen >= 0){
            if(s.charAt(sLen) == t.charAt(tLen)){
                sLen--;
                tLen--;
            }
            else{
                tLen--;
            }
        }
        return sLen == -1;
    }
}