class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> characterCounter = new HashMap<>();

        for (Character charac : s.toCharArray()) {
            characterCounter.put(charac, characterCounter.getOrDefault(charac, 0) + 1);
        }

        StringBuilder sBuilder = new StringBuilder();

        for (Character charac : order.toCharArray()) {
            if (characterCounter.containsKey(charac)) {
                for (int i = 0; i < characterCounter.get(charac); i++) {
                    sBuilder.append(charac);
                }
                characterCounter.remove(charac);
            }
        }

        for (Character charac : characterCounter.keySet()) {
            if (characterCounter.containsKey(charac)) {
                for (int i = 0; i < characterCounter.get(charac); i++) {
                    sBuilder.append(charac);
                }
            }
        }
        return sBuilder.toString();
    }
}