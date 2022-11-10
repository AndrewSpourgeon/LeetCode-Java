class Solution {
    public int compareVersion(String v1, String v2) {
        int dotv1 = (int)v1.chars().filter(ch -> ch == '.').count();
        int dotv2 = (int)v2.chars().filter(ch -> ch == '.').count();
        // --> keep both versions at same level
        if(dotv1 < dotv2){
            while(dotv1 != dotv2){
                v1 = v1 + ".0";
                dotv1++;
            }
        }
        else if(dotv2 < dotv1){
            while(dotv1 != dotv2){
                v2 = v2 + ".0";
                dotv2++;
            }
        }
        
        // --> check all values between all dots('.')
        int lenv1 = v1.length();
        int lenv2 = v2.length();
        int m = 0;
        int n = 0;
        int p = 0;
        int q = 0;
        for(int i = 0 ; i <= dotv1 ; i++){
            int str1 = 0;
            int str2 = 0;
            // check for substring in v1
            while(n < lenv1 && v1.charAt(n) != '.'){
                n++;
            }
            str1 = Integer.parseInt(v1.substring(m,n));
            m = n + 1;
            n = m + 1;
            
            
            //check for substring in v2
            while(q < lenv2 && v2.charAt(q) != '.'){
                q++;
            }
            str2 = Integer.parseInt(v2.substring(p,q));
            p = q + 1;
            q = p + 1;
            
            
            //compare both substrings
            if(str1 < str2) return -1;
            else if(str1 > str2) return 1;
        }
        
        return 0;
    }
}