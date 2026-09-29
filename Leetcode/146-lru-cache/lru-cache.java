class LRUCache {
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
        Node(int key,int val){
            this.key=key;
            this.val=val;
            prev=null;
            next=null;
        }
    }
    Node head=new Node(-1,-1);
    Node tail=new Node(-1,-1);
    int capacity;    
    HashMap<Integer, Node> map=new HashMap<>();

    public LRUCache(int capacity) {
       this.capacity=capacity;
       head.next=tail;  
       tail.prev=head; 
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node currNode=map.get(key);
        deleteNode(currNode);
        addNode(currNode);
        return currNode.val;        
    }
    public void put(int key, int value) {
        if(map.containsKey(key)){
            deleteNode(map.get(key));
            map.remove(key);
        }
        if(map.size()==capacity){
            map.remove(tail.prev.key);
            deleteNode(tail.prev);            
        }
        Node newNode=new Node(key,value);
        addNode(newNode);
        map.put(key,newNode);
    }
    public void addNode(Node newNode){
        Node oldNode=head.next;
        head.next=newNode;
        newNode.next=oldNode;
        oldNode.prev=newNode;
        newNode.prev=head;
    }
    public void deleteNode(Node tempNode){
        Node prevNode=tempNode.prev;
        Node nextNode=tempNode.next;
        prevNode.next=nextNode;
        nextNode.prev=prevNode;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */