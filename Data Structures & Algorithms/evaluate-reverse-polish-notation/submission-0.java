class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> resultsStack = new Stack<>();

        for (final String token : tokens) {
            Integer firstInteger;
            Integer secondInteger;
            switch (token) {
                case "+":
                    secondInteger = resultsStack.pop();
                    firstInteger = resultsStack.pop();
                    resultsStack.push(firstInteger + secondInteger);
                    break;
                case "-":
                    secondInteger = resultsStack.pop();
                    firstInteger = resultsStack.pop();
                    resultsStack.push(firstInteger - secondInteger);
                    break;
                case "*":
                    secondInteger = resultsStack.pop();
                    firstInteger = resultsStack.pop();
                    resultsStack.push(firstInteger * secondInteger);
                    break;
                case "/":
                    secondInteger = resultsStack.pop();
                    firstInteger = resultsStack.pop();
                    resultsStack.push(firstInteger / secondInteger);
                    break;
                default:
                    resultsStack.push(Integer.parseInt(token));
            }
        }
        return resultsStack.pop();
        
    }
}
