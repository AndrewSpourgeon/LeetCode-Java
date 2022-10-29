class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        int maxLen = 1;
        String ans = s.substring(0,1);
        //check for even length
        for(int i = 0 ; i < len ; i++){
            int left = i , right = i + 1;
            while(left >=0 && right < len){
                if(s.charAt(left) == s.charAt(right)){
                    int dis = right - left + 1;
                    if(dis > maxLen){
                        maxLen = dis;
                        ans = s.substring(left , right + 1);
                    }
                }
                else{
                    break;
                }
                left = left - 1;
                right = right + 1;
            }   
        }
        //check for odd length
        for(int i = 0 ; i < len ; i++){
            int left = i-1 , right = i + 1;
            while(left >=0 && right < len){
                if(s.charAt(left) == s.charAt(right)){
                    int dis = right - left + 1;
                    if(dis > maxLen){
                        maxLen = dis;
                        ans = s.substring(left , right + 1);
                    }
                }
                else{
                    break;
                }
                left = left - 1;
                right = right + 1;
            }   
        }
        return ans;
    }
}