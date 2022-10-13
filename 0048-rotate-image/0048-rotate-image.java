class Solution {
    public void rotate(int[][] matrix) {
        int size=matrix.length;
        int temp=0;
        for(int i=0;i<size;i++){
            for(int j=i+1;j<size;j++){
               temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for(int m=0;m<size;m++){
            for(int n=0;n<size/2;n++){
               temp=matrix[m][n];
                matrix[m][n]=matrix[m][size-1-n];
                matrix[m][size-1-n]=temp;
            }
        }
        
        
    }
}