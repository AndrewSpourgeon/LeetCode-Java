class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int len = tasks.length;
        if(len == 1) return -1;
        for(int i = 0 ; i < len ; i++){
            if(!map.containsKey(tasks[i])){
                map.put(tasks[i],1);
            }
            else{
                map.put(tasks[i],map.get(tasks[i])+1);
            }
        }
        if(map.containsValue(1)){
            return -1;
        }
        int ans = 0;
        for(int val : map.values()){
            //main core
            if(val == 2 || val == 4){
                ans += val/2;
                continue;
            }
            if(val % 3 == 0) {
                ans += val/3;
                continue;
            }
            
            ans += val/3;
            ans++;

        }
        return ans;
    }
}