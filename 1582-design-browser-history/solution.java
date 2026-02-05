class BrowserHistory {
    Stack<String> backHistory;
    Stack<String> forwardHistory;
    String currentPage;

    public BrowserHistory(String homepage) {
        currentPage = homepage;
        backHistory = new Stack<>();
        forwardHistory = new Stack<>();
    }
    
    public void visit(String url) {
        backHistory.push(currentPage);
        forwardHistory.clear();
        currentPage = url;
    }
    
    public String back(int steps) {
        int stepsTaken = 0;
        while (stepsTaken < steps && !backHistory.isEmpty()) {
            forwardHistory.push(currentPage);
            currentPage = backHistory.pop();
            stepsTaken++;
        }
        return currentPage;
    }
    
    public String forward(int steps) {
        int stepsTaken = 0;
        while (stepsTaken < steps && !forwardHistory.isEmpty()) {
            backHistory.push(currentPage);
            currentPage = forwardHistory.pop();
            stepsTaken++;
        }
        return currentPage;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */