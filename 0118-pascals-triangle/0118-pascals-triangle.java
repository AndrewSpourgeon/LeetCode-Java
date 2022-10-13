
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal=new ArrayList<List<Integer>>();
           for(int m=0;m<numRows;m++){
               List<Integer> temp=new ArrayList<Integer>();
               for(int n=0;n<=m;n++){
                   temp.add(1);
               }
               pascal.add(temp);
           }
        int size=2;     
            for(int i=size;i<=numRows-1;i++){
                int index=1;
                int count=0;
                while(count<i-1){
pascal.get(i).set(index,pascal.get(i-1).get(index-1)+pascal.get(i-1).get(index));
                    count=count+1;
                    index=index+1;  
                }                
            }        
        return pascal;   
    }
}