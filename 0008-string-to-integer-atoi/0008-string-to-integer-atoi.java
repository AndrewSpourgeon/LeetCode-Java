class Solution {
    public int myAtoi(String s) {
        int len = s.length();
        int sign = 1;
        long ans = 0;
        if(len == 0) return 0;
        String str = s.trim();
        int size = str.length();
        if(size == 0) return 0;
        if(str.charAt(0) == '-') sign = -1;
        int i = (str.charAt(0) == '-' || str.charAt(0) == '+') ? 1 : 0;
        while( i < size){
            if(str.charAt(i) == ' ' || !Character.isDigit(str.charAt(i))){
                break;
            }
            ans = (ans*10) + (long)(str.charAt(i) - '0');
            System.out.print(ans + "-");
            if(sign == -1 && -ans < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if(sign == 1 && ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            i = i + 1;
        }
        return (int)ans * sign;
    }
}