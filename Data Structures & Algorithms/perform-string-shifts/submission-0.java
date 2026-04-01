class Solution {
    public String stringShift(String s, int[][] shift) {
        Integer firstCharacter = 0;
        for (int[] singleShift : shift) {
            if (singleShift[0] == 0) {
                firstCharacter += singleShift[1];
            } else if (singleShift[0] == 1) {
                firstCharacter -= singleShift[1];
            }
        }
        System.out.println(firstCharacter);

        while (firstCharacter < 0) {
                firstCharacter = s.length() + firstCharacter; 
        }

        while (firstCharacter > s.length() - 1) {
            firstCharacter %= s.length();
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            Integer index = (firstCharacter + i) % s.length();
            result.append(s.charAt(index));
        }
        return result.toString();
    }
}
