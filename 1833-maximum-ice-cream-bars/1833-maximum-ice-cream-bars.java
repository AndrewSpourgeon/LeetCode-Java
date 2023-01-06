class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int bars = 0;
        for(int i = 0 ; i < costs.length && coins > 0 ; i++){
            if(coins >= costs[i]){
                bars++;
                coins -= costs[i];
            }
        }
        return bars;
    }
}