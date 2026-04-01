class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        List<List<Character>> characterOptions = new ArrayList();

        for (Character digit : digits.toCharArray()) {
            characterOptions.add(digetToCharacters(digit));
        }
        List<String> combinations = new ArrayList<>();

        letterCombinations(characterOptions, 0, "", combinations);
        return combinations;
    }

    private void letterCombinations(List<List<Character>> characterOptions, 
                                    Integer position, 
                                    String runningCombination, 
                                    List<String> combinations) {
        if (position == characterOptions.size()) {
            combinations.add(runningCombination);
            return;
        }
        for (Character singleCharacterOption : characterOptions.get(position)) {
            letterCombinations(characterOptions, position + 1, runningCombination + singleCharacterOption, combinations);
        }
    }

    private List<Character> digetToCharacters(Character diget) {
        switch (diget){
            case '2':
                return Arrays.asList('a', 'b', 'c');
            case '3':
                return Arrays.asList('d', 'e', 'f');
            case '4':
                return Arrays.asList('g', 'h', 'i');
            case '5':
                return Arrays.asList('j', 'k', 'l');
            case '6':
                return Arrays.asList('m', 'n', 'o');
            case '7':
                return Arrays.asList('p', 'q', 'r', 's');
            case '8':
                return Arrays.asList('t', 'u', 'v');
            case '9':
                return Arrays.asList('w', 'x', 'y', 'z');
        }
        return null;
    }
}
