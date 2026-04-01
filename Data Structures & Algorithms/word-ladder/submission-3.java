class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);

        HashMap<String, Set<String>> edgeMap = new HashMap<>();

        for (String firstWord : wordList) {
            for (String secondWord : wordList) {
                if (areOffByOne(firstWord, secondWord)) {
                    Set<String> children = edgeMap.getOrDefault(firstWord, new HashSet<>());
                    children.add(secondWord);
                    edgeMap.put(firstWord, children);
                }
            }
        }
        Set<String> visited = new HashSet<>();
        Integer[] result = new Integer[1];
        dfsSearch(edgeMap, beginWord, visited, endWord, result);
            
        return result[0] == null ? 0 : result[0];
    }

    public boolean areOffByOne(String first, String second) {
        Integer numberOfDiffs = 0;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                numberOfDiffs++;
                if (numberOfDiffs > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public void dfsSearch(HashMap<String, Set<String>> edgeMap, String key, Set<String> visited, String goal, Integer[] result) {
        if (visited.contains(key)) {
            return;
        }
        visited.add(key);
        if (key.equals(goal)) {
            if (result[0] == null) {
                result[0] = visited.size();
            } else {
                result[0] = Math.min(result[0], visited.size());
            }
        }
        Set<String> children = edgeMap.get(key);
        for (String child : children) {
            dfsSearch(edgeMap, child, visited, goal, result);
        }
        visited.remove(key);
    }
}
