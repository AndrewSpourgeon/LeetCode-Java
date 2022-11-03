class Solution {
    public String longestCommonPrefix(String[] strs) {
        int total = strs.length;
        if(total == 1) return strs[0];
        boolean isSame = false;
        String ans = "";
        for(int i = 0 ; i < strs[0].length() ; i++){
            char comm = strs[0].charAt(i); 
            for(int j = 1 ; j < total ; j++){
                if(i < strs[j].length() && strs[j].charAt(i) == comm){
                    isSame = true;
                }
                else{
                    isSame = false;
                }
                if(!isSame){
                    break;
                }
            }
            if(isSame){
                ans = ans + comm;
            }
            else{
                break;
            }
        }
        return ans;
    }
}