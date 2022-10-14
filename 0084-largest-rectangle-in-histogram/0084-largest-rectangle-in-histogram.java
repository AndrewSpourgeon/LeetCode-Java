class Solution {
    public int largestRectangleArea(int[] heights) {
        
        Stack<Integer> stack = new Stack<Integer>();
        int length = heights.length;
        if(length == 1){
            return heights[0];
        }
        int largestRect = 0;
        for(int i = 0 ; i < length ; i++){
            if(stack.empty()){
                stack.push(i);
            }
            else if(!stack.empty()){
                while(!stack.empty() && heights[i] < heights[stack.peek()]){
                    int topVal = heights[stack.pop()];
                    int rightBound = i;
                    int leftBound = stack.empty() ? -1 : stack.peek();
                    int area = topVal * (rightBound - (leftBound+1));
                    largestRect = Math.max(area , largestRect);
                }
                stack.push(i);
                
                if(i == length-1){
                while(!stack.empty()){
                    int topVal = heights[stack.pop()];
                    int rightBound = length;
                    int leftBound = stack.empty() ? -1 : stack.peek();
                    int area = topVal * (rightBound - (leftBound+1));
                    largestRect = Math.max(area , largestRect);
                }
            }
            }
        }
        return largestRect;
    }
}