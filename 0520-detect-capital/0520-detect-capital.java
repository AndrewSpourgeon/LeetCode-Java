class Solution {
    public boolean detectCapitalUse(String s) {
        int len = s.length();
        if(len == 1) return true;
        char c = s.charAt(0);
        char c1 = s.charAt(1);
            if(Character.isUpperCase(c) && Character.isUpperCase(c1)){
                int i = 2;
                while(i < len){
                    char temp = s.charAt(i);
                    if(!Character.isUpperCase(temp)){
                        return false;
                    }
                    i++;
                }
            }
            else if(Character.isUpperCase(c) && !Character.isUpperCase(c1)){
                int i = 2;
                while(i < len){
                    char temp = s.charAt(i);
                    if(Character.isUpperCase(temp)){
                        return false;
                    }
                    i++;
                }
            }
            else if(!Character.isUpperCase(c) && !Character.isUpperCase(c1)){
                int i = 2;
                while(i < len){
                    char temp = s.charAt(i);
                    if(Character.isUpperCase(temp)){
                        return false;
                    }
                    i++;
                }
            }
            else{
                return false;
            }
            return true;
        }
    
}