class MyQueue {
    Stack<Integer> input;
    Stack<Integer> output;
    public MyQueue() {
        input = new Stack<Integer>();
        output = new Stack<Integer>();
    }
    
    public void push(int x) {
        input.push(x);
    }
    
    public int pop() {
        if(output.size() == 0){
            int len = input.size();
            for(int i =1; i <= len; i++){
                output.push(input.pop());
            }
           return output.pop();
        }
        else{
           return output.pop();
        }
    }
    
    public int peek() {
        if(output.size() == 0){
            int len = input.size();
            for(int i =1; i <= len; i++){
                output.push(input.pop());
            }
           return output.peek();
        }
        else{
            return output.peek();
        }
    }
    
    public boolean empty() {
        if(output.size() == 0 && input.size() == 0){
            return true;
        }
        else{
            return false;
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */