class Solution {
    public int[][] merge(int[][] intervals) {
        int[] pair=new int[2];
        int size=intervals.length;        
        List<int[]> result=new ArrayList<>();
        Arrays.sort(intervals,new java.util.Comparator<int[]>() {
    public int compare(int[] a, int[] b) {
        return Integer.compare(a[0], b[0]);
    }
});
        pair=intervals[0];
        for(int i=0;i<size;i++){
            if(pair[1]>=intervals[i][0] && i!=0){
                pair[0]=Math.min(pair[0],intervals[i][0]);
                pair[1]=Math.max(pair[1],intervals[i][1]);
            }
            else if(i!=0){
                result.add(new int[]{pair[0],pair[1]});               
                pair=intervals[i];
            }           
        }
        result.add(new int[]{pair[0],pair[1]});
        int[][] merged=new int[result.size()][2];      
        for(int j=0;j<result.size();j++){
            merged[j]=result.get(j);       
        }
        return merged;
    }
}