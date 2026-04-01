class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> scoreHistory = new Stack();
        for (String operation : operations) {
            if (operation.equals("+")) {
                Integer secondScore = scoreHistory.pop();
                Integer firstScore = scoreHistory.peek();
                Integer sum = firstScore + secondScore;
                scoreHistory.push(secondScore);
                scoreHistory.push(sum);
            } else if (operation.equals("D")) {
                Integer previousScore = scoreHistory.peek();
                scoreHistory.push(previousScore * 2);
            } else if (operation.equals("C")) {
                scoreHistory.pop();
            } else {
                scoreHistory.push(Integer.parseInt(operation));
            }
        }
        Integer finalScore = 0;
        for (Integer score : scoreHistory) {
            finalScore += score;
        }
        return finalScore;
    }
}