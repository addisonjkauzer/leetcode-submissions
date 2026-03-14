class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        char[] chs = s.toCharArray();
        Character[] characters = new Character[chs.length];
        for (int i = 0; i < chs.length; i++) {
            characters[i] = chs[i];
        }
        Arrays.sort(characters, Collections.reverseOrder());

        char previous = characters[0];
        int count = 1;
        StringBuilder result = new StringBuilder();
        result.append(characters[0]);
        int pointer = 1;
        for (int i = 1; i < characters.length; i++) {
            char current = characters[i];
            if (current == previous) {
                count++;
            } else {
                count = 1;
            }
            if (count > repeatLimit) {
                if (pointer < i) {
                    pointer = i;
                }
                while (pointer < characters.length && characters[pointer] == previous) {
                    pointer++;
                }
                if (pointer == characters.length) {
                    return result.toString();
                }
                char temp = characters[i];
                characters[i] = characters[pointer];
                characters[pointer] = temp;
                count = 1;
            }
            result.append(characters[i]);
            previous = characters[i];
        }
        return result.toString();
    }
}