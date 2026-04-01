class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer[]> characterToInterval = new HashMap<>();
        ArrayList<Character> characterOrder = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            if (characterToInterval.containsKey(character)) {
                characterToInterval.put(character, new Integer[] {characterToInterval.get(character)[0], i});
            } else {
                characterToInterval.put(character, new Integer[] {i, i});
                characterOrder.add(character);
            }
        }
        List<Integer> nonOverlappingIntervals = new ArrayList<>();
        Integer[] previous = characterToInterval.get(characterOrder.get(0));
        for (Character character : characterOrder) {
            Integer[] current = characterToInterval.get(character);
            if (previous[1] >= current[0]) {
                previous = new Integer[] {previous[0], Math.max(previous[1], current[1])};
            } else {
                nonOverlappingIntervals.add(previous[1] - previous[0] + 1);
                previous = current;
            }
        }
        nonOverlappingIntervals.add(previous[1] - previous[0] + 1);
        return nonOverlappingIntervals;
    }
}
