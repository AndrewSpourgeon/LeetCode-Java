class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
        int len = points.length,shots=1;
        int prev = 0;
        for(int current = 1 ; current < len ; current++){
            if(points[current][0] > points[prev][1]){
                shots++;
                prev = current;
            }
        }
        return shots;
    }

   
}