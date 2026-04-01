class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        HashMap<Character, TrieNode> currentChildren = root.children;
        TrieNode child = new TrieNode();
        for (final Character character : word.toCharArray()) {
            if (!currentChildren.keySet().contains(character)) {
                child = new TrieNode();
                currentChildren.put(character, child);
            } else {
                child = currentChildren.get(character);
            }
            currentChildren = child.children;
        }
        child.finalCharacter = true;
    }

    public boolean search(String word) {
        return search(word, root);
    }

    public boolean search(String word, TrieNode node) {
        if (word.length() == 0) {
            return node.finalCharacter;
        }
        Character firstCharacter = word.charAt(0);
        if (firstCharacter.equals('.')) {
            Boolean result = false;
            for (TrieNode childNode : node.children.values()) {
                result = result || search(word.substring(1, word.length()), childNode);
            }
            return result;
        }
        if (node.children.keySet().contains(firstCharacter)) {
            return search(word.substring(1, word.length()), node.children.get(firstCharacter));
        } else {
            return false;
        }
    }
}

class TrieNode {
    HashMap<Character, TrieNode> children;
    Boolean finalCharacter;

    public TrieNode() {
        children = new HashMap<>();
        finalCharacter = false;
    }
}
