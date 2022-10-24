class MinStack {
    Stack<Long> stack;
    Long min;
    public MinStack() {
        stack = new Stack<Long>();
    }
    
    public void push(int val) {
        Long el = Long.valueOf(val);
        if(stack.empty()){
            stack.push(el);
            min = el;
        }
        else{
            if(el >= min){
                stack.push(el);
            }
            else{
                stack.push(2*el - min);
                min = el;
            }
        }
    }
    
    public void pop() {
        if(stack.peek() < min){
            min = 2*min - stack.peek();
            stack.pop();
        }
        else{
            stack.pop();
        }
    }
    
    public int top() {
        if(stack.peek() < min){
            return min.intValue();
        }
        else{
            return stack.peek().intValue();
        }
    }
    
    public int getMin() {
        return min.intValue();
    }
    
    
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */