class Solution {
    
    private HashMap<Integer, Integer> previouslyComputed = new HashMap<>();
    public int climbStairs(int n) {
        if(previouslyComputed.containsKey(n)) {
            return previouslyComputed.get(n);
        }
        if (n == 2) {
            return 2;
        }
        if (n == 1) {
            return 1;
        }
        if (n < 1) {
            return 0;
        }
        int steps = climbStairs(n-1) + climbStairs(n-2);
        previouslyComputed.put(n, steps);
        return steps;
    }
}