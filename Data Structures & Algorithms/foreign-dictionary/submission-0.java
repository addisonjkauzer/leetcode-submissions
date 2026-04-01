class Solution {
    public String foreignDictionary(String[] words) {
        HashMap<Character, Set<Character>> edgeMap = new HashMap<>();
        for (String word : words) {
            for (Character character : word.toCharArray()) {
                edgeMap.put(character, new HashSet<>());
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            Integer index = 0;
            String leftWord = words[i];
            String rightWord = words[i + 1];
            if (leftWord.length() > rightWord.length() && leftWord.substring(0, rightWord.length()).equals(rightWord)) {
                return "";
            }
            while (index < Math.min(leftWord.length(), rightWord.length())) {
                if (leftWord.charAt(index) != rightWord.charAt(index)) {
                    edgeMap.get(leftWord.charAt(index)).add(rightWord.charAt(index));
                    break;
                }
                index++;
            }
        }
        HashSet<Character> visited = new HashSet<>();
        StringBuilder result = new StringBuilder();
        for (Character key : edgeMap.keySet()) {
            if (bottomUpDFS(edgeMap, key, new HashSet<>(), visited, result)) {
                return "";
            }
        }
        return result.reverse().toString();
    }

    public boolean bottomUpDFS(Map<Character, Set<Character>> edgeMap, Character currentNode, Set<Character> path, Set<Character> visited, StringBuilder result) {
        if (visited.contains(currentNode)) {
            return false;
        }
        Set<Character> children = edgeMap.get(currentNode);
        for (Character child : children) {
            if (path.contains(child)) {
                return true;
            }
            path.add(child);
            if (bottomUpDFS(edgeMap, child, path, visited, result)) return true;
            path.remove(child);
        }
        visited.add(currentNode);
        result.append(currentNode);
        return false;
    }
}
