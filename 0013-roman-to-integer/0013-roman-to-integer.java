class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        int len = s.length();
        int i = 0;
        while( i < len ){
            int cur = getVal(s.charAt(i));
            if(i < len - 1 && cur < getVal(s.charAt(i+1))){
                ans = ans + (getVal(s.charAt(i+1)) - cur);
                i = i + 2;
            }
            else{
                ans = ans + cur;
                i = i + 1;
            }
        }
        return ans;
    }
    
    private int getVal(char ch){
        int ans = 0;
        switch(ch){
            case 'I':
                ans = 1;
                break;
            case 'V':
                ans = 5;
                break;
            case 'X':
                ans = 10;
                break;
            case 'L':
                ans = 50;
                break;
            case 'C':
                ans = 100;
                break;
            case 'D':
                ans = 500;
                break;
            case 'M':
                ans = 1000;
                break;
        }
        return ans;
    }
}