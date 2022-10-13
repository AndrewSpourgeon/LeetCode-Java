class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
		int n1 = -1;
		int n2 = -1;
		int count1 = 0;
		int count2 = 0;
        //check for the voting of numbers
		for(int i : nums){
			if(i==n1) count1++;
			else if(i == n2) count2++;
			else if (count1==0){
				n1 = i;
				count1 = 1;
			}
			else if(count2==0){
				n2 = i;
				count2 = 1;
			}
			else{
				count1--;
				count2--;
			}
		}
        //check if the numbers exist in original array
		int cnt1 = 0;
		int cnt2 = 0;
        
		for(int i=0;i<nums.length;i++){
		   if(nums[i]==n1){
			   cnt1++;
		   }
			else if(nums[i]==n2){
				cnt2++;
			}
		}
		int t = nums.length/3;
        //check if number are not duplicate
		if(cnt1>t) list.add(n1);
		if(cnt2>t && n1!=n2) list.add(n2);

		return list;
    }
}