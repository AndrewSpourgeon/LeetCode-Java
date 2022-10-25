class StockSpanner {
    Stack<Stock> stack;
    int span = 0;
    public StockSpanner() {
        stack = new Stack<Stock>();
    }
    
    public int next(int price) {
        if(stack.empty()){
            stack.push(new Stock(price,span));
            span = span + 1;
            return span;
        }
        else{
            while(!stack.empty() && price >= stack.peek().price){
                stack.pop();
            }
            if(stack.empty()){
                stack.push(new Stock(price,span));
                span = span + 1;
                return span;
            }
            else{
                int temp = span - stack.peek().day;
                stack.push(new Stock(price , span));
                span = span + 1;
                return temp;
            }
        }
        
    }
}
class Stock {
    int price;
    int day;
    public Stock(int price , int day){
        this.price = price;
        this.day = day;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */