class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] shiftsRecord = new int[s.length() + 1];
        for (int [] shift : shifts) {
            int startIndex = shift[0];
            int endIndex = shift[1];
            int direction = shift[2];
            if (direction == 1) {
                shiftsRecord[startIndex] += 1;
                shiftsRecord[endIndex + 1] -= 1;
            } else if (direction == 0) {
                shiftsRecord[startIndex] += -1;
                shiftsRecord[endIndex + 1] -= -1;
            }
        }
        char[] sChars = s.toCharArray();
        for (int i = 0; i < sChars.length; i++) {
            sChars[i] -= 'a';
        }

        int runningSum = 0;
        for (int i = 0; i < sChars.length; i++) {
            runningSum += shiftsRecord[i];
            sChars[i] = (char)((((int)sChars[i] + runningSum % 26) + 26) % 26);
        }

        for (int i = 0; i < sChars.length; i++) {
            sChars[i] += 'a';
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(sChars);
        return stringBuilder.toString();
    }
}