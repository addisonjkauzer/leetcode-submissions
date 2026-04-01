class Solution {
    Set<String> returned;
    boolean[][] used;

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            root.addWord(word);
        }

        used = new boolean[board.length][board[0].length];
        returned = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                findWord(board, i, j, root, "");
            }
        } 
        return new ArrayList<>(returned);
    }

    public void findWord(char[][] board, Integer i, Integer j, TrieNode node, String word) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || used[i][j] == true || !node.children.containsKey(board[i][j])) {
            return;
        }

        used[i][j] = true;
        node = node.children.get(board[i][j]);
        word += board[i][j];

        if (node.lastCharacter) {
            returned.add(word);
        }

        findWord(board, i + 1, j, node, word);
        findWord(board, i - 1, j, node, word);
        findWord(board, i, j + 1, node, word);
        findWord(board, i, j - 1, node, word);

        used[i][j] = false;
    }
}

class TrieNode {
    HashMap<Character, TrieNode> children;
    Boolean lastCharacter;

    public TrieNode() {
        children = new HashMap<>();
        lastCharacter = false;
    }

    public void addWord(String word) {
        TrieNode current = this;
        for(Character character : word.toCharArray()) {
            current.children.putIfAbsent(character, new TrieNode());
            current = current.children.get(character);
        }
        current.lastCharacter = true;
    }
}
