class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minAtPoint;

    public MinStack() {
        stack = new Stack<>();
        minAtPoint = new Stack<>();
    }
    
    public void push(int val) {
        Integer currentMin;
        if (minAtPoint.size() == 0) {
            currentMin = val;
        } else {
            currentMin = this.getMin();
        }
        stack.add(val);
        minAtPoint.add(Math.min(currentMin, val));
    }
    
    public void pop() {
        minAtPoint.pop();
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minAtPoint.peek();
    }
}
