class Solution {
    public List<String> removeSubfolders(String[] folder) {
        TrieNode root = new TrieNode("", false);

        for (String path : folder) {
            root.addPath(path);
        }

        return dfsFindFirstEnd(root, "");
        
    }

    public List<String> dfsFindFirstEnd(TrieNode root, String path) {
        if (root.isEnd) {
            return Arrays.asList(path.substring(1));
        }
        List<String> result = new ArrayList<>();
        for (TrieNode child : root.children.values()) {
            result.addAll(dfsFindFirstEnd(child, path + "/" + child.path));
        }
        return result;
    }
}

class TrieNode {
    public HashMap<String, TrieNode> children;
    public String path;
    public boolean isEnd;

    public TrieNode(String path, boolean isEnd) {
        this.path = path;
        this.isEnd = isEnd;
        this.children = new HashMap<>();
    }

    public void addPath(String path) {
        HashMap<String, TrieNode> currentChildren = children;
        String[] directories = path.split("/");
        TrieNode child = currentChildren.getOrDefault(directories[0], new TrieNode(directories[0], false));
        for (String directory : directories) {
            child = currentChildren.getOrDefault(directory, new TrieNode(directory, false));
            currentChildren.put(directory, child);
            currentChildren = child.children;
        }
        child.isEnd = true;

    }
}