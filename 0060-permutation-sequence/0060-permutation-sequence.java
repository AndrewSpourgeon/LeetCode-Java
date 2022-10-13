class Solution {
    public String getPermutation(int n, int k) {
        String ans = "";
        int fact = 1;
        List<Integer> temp = new ArrayList<Integer>();
        for(int i=1;i<n;i++){
            fact = fact * i;
            temp.add(i);
        }
        temp.add(n);
        k = k-1;
        while(true){
            ans = ans + temp.get(k/fact);
            temp.remove(k/fact);
            k = k % fact;
            if(temp.size()==0) break;
            fact = fact / temp.size();
            
        }
        return ans;
    }
}