class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        int count = 0;
        for(int i = 0 ; i < m ; i++){
            char c = strs[0].charAt(i);
            for(int j = 1 ; j < n ; j++){
                if(strs[j].charAt(i)-'a' < c - 'a'){
                    count++;
                    break;
                }
                c = strs[j].charAt(i);
            }
        }
        return count;
    }
}