class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
         maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
         minHeap = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        if(maxHeap.size() == 0 || maxHeap.peek() > num){
            maxHeap.add(num);
        }
        else{
            minHeap.add(num);
        }
        if(maxHeap.size() > minHeap.size() + 1){
            minHeap.add(maxHeap.poll());
        }
        else if(minHeap.size() > maxHeap.size() + 1){
            maxHeap.add(minHeap.poll());
        }
        System.out.print(maxHeap.peek());
    }
    
    public double findMedian() {
       if(maxHeap.size() > minHeap.size()){
           return maxHeap.peek()/1.0;
       }
       else if(minHeap.size() > maxHeap.size()){
           return minHeap.peek()/1.0;
       }
       else{
           return (minHeap.peek() + maxHeap.peek())/2.0;
       }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */