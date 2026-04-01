class PrefixTree {

    HashMap<Character, TrieNode> roots;

    public PrefixTree() {
        roots = new HashMap<>();
    }

    public void insert(String word) {
        HashMap<Character, TrieNode> currentChildren = roots;
        TrieNode child = currentChildren.getOrDefault(word.charAt(0), new TrieNode(word.charAt(0)));
        for (Character character : word.toCharArray()) {
            child = currentChildren.getOrDefault(character, new TrieNode(character));
            currentChildren.put(character, child);
            currentChildren = child.children;
        }
        child.isEndNode = true;
    }

    public boolean search(String word) {
        HashMap<Character, TrieNode> currentChildren = roots;
        TrieNode lastLetter = currentChildren.getOrDefault(word.charAt(0), new TrieNode(word.charAt(0)));
        for (Character character : word.toCharArray()) {
            if (currentChildren.keySet().contains(character)) {
                lastLetter = currentChildren.get(character);
                currentChildren = currentChildren.get(character).children;
            } else {
                return false;
            }
        }

        if (lastLetter.isEndNode) {
            return true;
        }
        return false;

    }

    public boolean startsWith(String prefix) {
        HashMap<Character, TrieNode> currentChildren = roots;
        for (Character character : prefix.toCharArray()) {
            if (currentChildren.keySet().contains(character)) {
                currentChildren = currentChildren.get(character).children;
            } else {
                return false;
            }
        }
        return true;
    }
}

class TrieNode {
    Character val;
    HashMap<Character, TrieNode> children;
    Boolean isEndNode;

    public TrieNode(final Character val) {
        this.val = val;
        children = new HashMap<>();
        isEndNode = false;
    }
}
