class Solution {
    public int minOperations(String[] logs) {
        int operations = 0;
        for (String log : logs) {
            if (log.charAt(0) == '.') {
                if (log.charAt(1) == '.') {
                    operations--;
                    if (operations < 0) operations = 0;
                }
            } else {
                operations++;
            }
        }
        return operations;
    }
}