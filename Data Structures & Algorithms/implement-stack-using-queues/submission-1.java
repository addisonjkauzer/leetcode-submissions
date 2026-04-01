class MyStack {

    Queue<Integer> fullQueue;
    Queue<Integer> emptyQueue;

    public MyStack() {
        fullQueue = new LinkedList<>();
        emptyQueue = new LinkedList<>();
    }
    
    public void push(int x) {
        while (!fullQueue.isEmpty()) {
            emptyQueue.add(fullQueue.remove());
        }
        fullQueue.add(x);
        while (!emptyQueue.isEmpty()) {
            fullQueue.add(emptyQueue.remove());
        }
    }
    
    public int pop() {
        if (this.empty()) {
            return -1;
        }
        return fullQueue.remove();
    }
    
    public int top() {
        return fullQueue.peek();
    }
    
    public boolean empty() {
        return fullQueue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */