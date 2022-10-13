class Solution {
    public double myPow(double x, int n) {
       double result=1;
        long temp=n;
       if(temp<0) temp=-1*n;
          while(temp>0){
           if(temp%2==0){
               x=x*x;
               temp=temp/2;
           }
           else{
               result=result*x;
               temp=temp-1;
           }
         }
        
    if(n<0) result=1/result;
    if(n==Integer.MIN_VALUE){
        if(x>1){
        result=0;
        }
        else{
            
            result=1;
        }
    }
       
       
        return result;
    }
}