class Node{
    int value;
    Node next;
    Node(int data){
        value = data;
        next = null;
    }
}

class MyLinkedList {
    Node head;
    public MyLinkedList() {
        head = null;
    }
    
    public int get(int index) {
        Node temp = head;
        int counter = 0;
        int answer;
        while(temp != null && counter != index){
            temp = temp.next;
            counter++;
        }
        if(temp == null){
            return -1;
        }
        answer = temp.value;
        return answer;
    }
    
    public void addAtHead(int val) {
        Node node = new Node(val);
        if(head == null){
            head = node;
        }
        else{
            node.next = head;
            head = node;
        }
    }
    
    public void addAtTail(int val) {
        Node node = new Node(val);
        if(head == null){
            head = node;
        }else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = node;
        }
    }
    
    public void addAtIndex(int index, int val) {
        int size = getSize();
        if(index > size) return;
        if(index == size){
            addAtTail(val);
        }
        if(index == 0){
            addAtHead(val);
        }else{
            Node node = new Node(val);
            int currIndex = 0;
            Node temp = head;
            while(currIndex != index - 1){
                temp = temp.next;
                currIndex++;
            } 
            node.next = temp.next;
            temp.next = node;
        }
    }
    
    public void deleteAtIndex(int index) {
        if(head == null) return;
        if(index == 0){
            head = head.next;
        }
        Node temp = head;
        int currIndex = 0;
        while(temp != null && currIndex != index - 1){
            temp = temp.next;
            currIndex++;
        }
        if(temp == null || temp.next == null) return;
        Node ptr = temp.next;
        temp.next = temp.next.next;
        ptr = null;
    }
    private int getSize(){
        if(head == null) return 0;
        int size = 1;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        return size;
    }
}

