class LRUCache {
   Map<Integer,Node> cache;
    Node head = new Node(0,0) , tail = new Node(0,0);
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<Integer,Node>();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            
            swapTheNode(node);
            
            cache.replace(key,node);
            
            return node.value;
        }
        else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            
            swapTheNode(node);
            
            node.value = value;
            
            cache.replace(key,node);
        }
        else{
            Node node = new Node(key,value);
            int length = cache.size();
            if(length == capacity){
                int k = tail.prev.key;
                cache.remove(k);
                
                tail.prev = tail.prev.prev;
                tail.prev.next = tail;
                
                insertAfterHead(node);
                
                cache.put(key, node);
            }
            else{
                insertAfterHead(node);
                
                cache.put(key,node);
            }
            
        }
    }
    private void swapTheNode(Node node){
            Node nxt = node.next;
            Node previous = node.prev;
            nxt.prev = previous;
            previous.next = nxt;
            
            node.next = head.next;
            node.prev = head;
            node.next.prev = node;
            head.next = node;
    }
    
    private void insertAfterHead(Node node){
        node.next = head.next;
        node.prev = head;
        head.next = node;
        node.next.prev = node;
    }
}
class Node{
    Node prev , next;
    int key;
    int value;
    public Node(int key,int value){
        this.key = key;
        this.value = value;
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */