class Solution {
     Map<Character,Integer> romanValues=new HashMap<Character,Integer>(){{
           put('I',1);
           put('V',5);
           put('X',10);
           put('L',50);
           put('C',100);
           put('D',500);
           put('M',1000);
           
       }};
    public int romanToInt(String s) {
       int result=0;
       char[] romanChars=s.toCharArray();
       int size=romanChars.length;
       for(int i=0;i<romanChars.length;i++){
            if( (i<size-1 && romanChars[i]=='I' && romanChars[i+1]=='I' )||(i==size-1 && romanChars[i]=='I')){
               result+=1;
           }
          else if(i<size-1 && getVal(romanChars[i])<getVal(romanChars[i+1])){
               result+=getVal(romanChars[i+1])-getVal(romanChars[i]);
               i=i+1;
           }
           else if(i<size-2 && getVal(romanChars[i])>getVal(romanChars[i+1]) && getVal(romanChars[i+1])<getVal(romanChars[i+2])){
               result+=getVal(romanChars[i]);
               result+=getVal(romanChars[i+2])-getVal(romanChars[i+1]);
                i=i+2;
                
                
           }
           else if(i<size-1 && getVal(romanChars[i]) > getVal(romanChars[i+1])) {         
               result+=getVal(romanChars[i])+getVal(romanChars[i+1]);
               i++;
           }
          else if(i<size-1&&getVal(romanChars[i])==getVal(romanChars[i+1])){
              result+=getVal(romanChars[i])+getVal(romanChars[i+1]);
              i++;
          }
           else{
               result+=getVal(romanChars[i]);
           }
       }
       return result; 
    }
    
   public int getVal(char c){
       return romanValues.get(c);
    }
}