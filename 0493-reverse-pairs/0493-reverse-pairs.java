class Solution {
     int count=0;
    public int reversePairs(int[] nums) {
        divide(nums);
        return count;
    }
     private void divide(int[] array) {
            int size=array.length;
            int mid=size/2;
            int[] left=new int[mid];
            int[] right=new int[size-mid];
            if(size<2){
                return;
            }
            else{
                for(int i=0;i<mid;i++){
                    left[i]=array[i];
                }
                for(int i=mid;i<size;i++){
                    right[i-mid]=array[i];
                }
            }
            divide(left);
            divide(right);
            conquer(array,left,right);
        }
        private void conquer(int[] array, int[] left, int[] right) {
            int i=0;
            int j=0;
            int k=0;
            int m=0;
            int n=0;
            while(m<left.length && n<=right.length){
                if( n!=right.length && Math.ceil(Double.valueOf(left[m])/2) > right[n]){
                    n++;
                }
                else{
                    m++;
                    count=count+n;
                }
            }
            while(i<left.length && j<right.length){
                 if(left[i]<right[j]){
                    array[k]=left[i];
                    i++;
                 }
                 else{
                    array[k]=right[j];
                    j++;
                 }
                 k++;
            }
            while(i<left.length){
                array[k]=left[i];
                i++;
                k++;
            }
            while(j<right.length){
                array[k]=right[j];
                j++;
                k++;
            }
        }
}