class Solution {
    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        if(n == 2){
            return "11";
        }
        if(n == 3){
            return "21";
        }   
        String temp = countAndSay(n-1);
        String ans = say(temp);
        return ans;
    }
    
    private String say(String s){
        if(s.length() == 1) return "1" + s;
        int count = 1;
        String temp = "";
        int i = 0;
        while( i < s.length()){
            while( i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)){
                count++;
                i++;
            }
            temp = temp + (char)(count + '0') + s.charAt(i);
            count = 1;
            i++;
            if(i == s.length()-1){
                temp = temp + (char)(count + '0') + s.charAt(i);
                break;
            }
        }
        return temp;
    }
}