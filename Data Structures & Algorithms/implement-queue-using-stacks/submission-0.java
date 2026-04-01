class MyQueue {
    Stack<Integer> fullStack;
    Stack<Integer> emptyStack;

    public MyQueue() {
        fullStack = new Stack<>();
        emptyStack = new Stack<>();
    }
    
    public void push(int x) {
        while (!fullStack.isEmpty()) {
            emptyStack.push(fullStack.pop());
        }
        emptyStack.push(x);
        while (!emptyStack.isEmpty()) {
            fullStack.push(emptyStack.pop());
        }
    }
    
    public int pop() {
        return fullStack.pop();
    }
    
    public int peek() {
        return fullStack.peek();
    }
    
    public boolean empty() {
        return fullStack.isEmpty();
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