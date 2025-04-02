class MyCircularQueue {
    int [] queue;
    int front;
    int rear;
    int n;
    public MyCircularQueue(int size) {
        queue = new int[size];
        front = -1;
        rear = -1;
        n = size;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        if(isEmpty()){
            front = 0;
            rear = 0;
            queue[rear] = value;
        }else{
            rear = (rear + 1)%n;
            queue[rear] = value;
        }
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        int tbd;
        if(rear == front){
            tbd = queue[front];
            front = -1;
            rear = -1;
        }
        else{
            tbd = queue[front];
            front = (front + 1) % n;
        }
        return true;
    }
    
    public int Front() {
        if(isEmpty()) return -1;
        return queue[front];
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
        return queue[rear];
    }
    
    public boolean isEmpty() {
        if(front == -1 && rear == -1){
            return true;
        }
        return false;
    }
    
    public boolean isFull() {
        if((rear + 1) % n == front){
            return true;
        }
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */