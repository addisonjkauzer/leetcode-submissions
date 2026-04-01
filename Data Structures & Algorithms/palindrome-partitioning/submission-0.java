class Solution {
    public List<List<String>> partition(String s) {
        List<String> runningPartition = new ArrayList<>();
        List<List<String>> results = new ArrayList<>();

        buildPalindromes(s, 0, 1, runningPartition, results);
        return results;
    }

    public void buildPalindromes(String s, 
                                int startIndex, 
                                int endIndex, 
                                List<String> runningPartition, 
                                List<List<String>> results) {
        if (endIndex > s.length()) {
            return;
        }
        if (isPalindrome(s.substring(startIndex, endIndex))) {
            runningPartition.add(s.substring(startIndex, endIndex));
            if (endIndex == s.length()) {
                results.add(new ArrayList(runningPartition));
            }
            buildPalindromes(s, endIndex, endIndex + 1, runningPartition, results);
            runningPartition.remove(runningPartition.size() - 1);
        }
        buildPalindromes(s, startIndex, endIndex + 1, runningPartition, results);
    }

    public boolean isPalindrome(String s) {
        Integer leftPointer = 0;
        Integer rightPointer = s.length() - 1;

        while (leftPointer <= rightPointer) {
            if (s.charAt(leftPointer) != s.charAt(rightPointer)) {
                return false;
            }
            leftPointer++;
            rightPointer--;
        }
        return true;
    }
}
