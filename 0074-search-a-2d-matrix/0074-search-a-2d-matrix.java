class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int x=0;
        boolean isFound=false;
        if(target>=matrix[matrix.length-1][0]){
            x=matrix.length-1;
        }
        else{
            for(int i=0;i<matrix.length-1;i++){
                if(target>=matrix[i][0] && target < matrix[i+1][0]){
                    x=i;
             }
           }
        }
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[x][i]==target){
                isFound=true;
            }
        }
        return isFound;
    }
}