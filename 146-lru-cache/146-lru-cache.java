class LRUCache {
    
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        
        Node(int key, int value){
        this.key = key;
        this.value = value;
        this.prev=this.next=null;
        }
    }
    
    HashMap<Integer, Node> map = null;
    private Node head = null;
    private Node tail = null;
    private int size=0;
    private int cap=0;
    
    private void addLast(Node node){
        if(this.size==0){
            this.head = this.tail=node;
            this.size = 1;
        }else{
            this.tail.next = node;
            node.prev = tail;
            this.tail = node;
            size++;
        }
    }
    private void removeNode(Node node){
        if(this.size == 1){
            this.head = this.tail = null;
        }
        else if(node == this.head){
            this.head = head.next;
            this.head.prev = null;
        }else if(node == this.tail){
            this.tail = tail.prev;
            this.tail.next = null;
        }else{
            Node n1 = node.prev;
            Node n2 = node.next;
            n1.next = n2;
            n2.prev=n1;
            node.next = node.prev = null;
        }
        this.size--;
        
    }
    public int removeFirst(){
        //there is always more than one element
        Node rem = head;
        head = head.next;
        head.prev = null;
        rem.next = null;
        this.size--;
        return rem.key;
    }
    

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            //get value
            int val = map.get(key).value;
            //set it on top
            this.put(key, val);
            return val;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        
        if(map.containsKey(key)){
            //updation
            Node node = map.get(key);
            node.value = value;
            this.removeNode(node);
            this.addLast(node);   
        }else{
            //addition of next key-value
            Node node = new Node(key, value);
            map.put(key, node);
            this.addLast(node);
            
            if(this.size > cap){
                int removalKey = this.removeFirst();
                map.remove(removalKey);
            }
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */