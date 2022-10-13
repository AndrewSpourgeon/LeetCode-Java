class LFUCache {
    int capacity;
    int curSize;
    int minFrequency;
    Map<Integer,Node> cache;
    Map<Integer,DLL> frequencyList;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.curSize = 0;
        this.minFrequency = 0;
        this.cache = new HashMap<Integer,Node>();
        this.frequencyList = new HashMap<Integer,DLL>();
    }
    
    public int get(int key) {
         Node node = cache.get(key);
         if(node == null){
             return -1;
         }
        updateNode(node);
        
        return node.value; 
    }
    
    public void put(int key, int value) {
       
        if(capacity == 0){
            return;
        }
        if(cache.containsKey(key)){
            Node curNode = cache.get(key);
            curNode.value = value;
            updateNode(curNode);
            
        }
        else{
            Node curNode = new Node(key,value);
            curSize = curSize + 1;
            
            if(curSize > capacity){
               DLL list = frequencyList.get(minFrequency);
               cache.remove(list.tail.prev.key);
               list.removeNode(list.tail.prev);
               curSize = curSize - 1;
            }
                minFrequency = 1;
                DLL list = frequencyList.getOrDefault(1,new DLL());
                list.addNode(curNode);
                frequencyList.put(1,list);
                cache.put(key,curNode);
        }
        
    }
    
    public void updateNode(Node curNode){
        int frequency = curNode.frequency;
        DLL list = frequencyList.get(frequency);
        list.removeNode(curNode);
        
        if(frequency == minFrequency && list.listSize == 0){
            minFrequency = minFrequency + 1;
        }
        
        curNode.frequency = frequency + 1;
        DLL dlist = frequencyList.getOrDefault(curNode.frequency , new DLL());
        dlist.addNode(curNode);
        frequencyList.put(curNode.frequency,dlist);
    }
}

class Node{
    int key;
    int value;
    int frequency;
    Node next;
    Node prev;
    public Node(int key,int value){
        this.key = key;
        this.value = value;
        this.frequency = 1;
    }
}
class DLL{
    Node head;
    Node tail;
    int listSize;
    public DLL(){
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        this.listSize = 0;
    }
    public void addNode(Node node){
        node.next = head.next;
        node.prev = head;
        head.next = node;
        node.next.prev = node;
        listSize = listSize + 1;
    }
    public void removeNode(Node node){
        Node previous = node.prev;
        Node nxt = node.next;
        previous.next = nxt;
        nxt.prev = previous;
        listSize = listSize - 1;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */