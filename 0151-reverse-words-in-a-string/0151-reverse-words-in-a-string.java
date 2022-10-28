class Solution {
    public String reverseWords(String s) {
        int len = s.length();
        int i = 0;
        String res = "";
        while(i < len){
             while(i < len && s.charAt(i) == ' '){
                 i = i + 1;
             }
            if(i >= len) break;
             int j = i;
            while( j < len && s.charAt(j) != ' ' ){
                j = j + 1;
            }
            String temp = s.substring(i,j);
            if(res.length() != 0){
                res = temp + " " + res; 
            }
            else{
                 res = temp;
                
            }
            i = j + 1;
        }
        return res;
    }
}