class Solution {
    public int minimumLength(String s) {
        HashMap<Character, Integer> characterCounter = new HashMap<>();

        for (Character character : s.toCharArray()) {
            characterCounter.put(character, characterCounter.getOrDefault(character, 0) + 1);
        }

        Integer length = 0;

        for (Character key : characterCounter.keySet()) {
            Integer count = characterCounter.get(key);

            if (count == 1) {
                length++;
                continue;
            }
            if (count % 2 == 0) {
                length = length + 2;
            } else {
                length++;
            }
        }

        return length;
    }
}