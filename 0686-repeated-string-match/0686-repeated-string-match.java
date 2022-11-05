class Solution {
    public int repeatedStringMatch(String a, String b) {
        int initLen = a.length();
        String aCopy = a;
        int count = 1;
        //multiply the string a until it will be >= to length of String b
        while(initLen < b.length()){
            aCopy = aCopy + a;
            initLen = initLen + a.length();
            count = count + 1;
        }
        
        //check if a is substring of b
        if(isSubString(aCopy , b) != -1){
            return count;
        }
        if(isSubString(aCopy+a , b) != -1){
            return count+1;
        }
        
        
        return -1;
        
    }
    
    private int isSubString(String a , String b){
        return a.indexOf(b);
    }
}