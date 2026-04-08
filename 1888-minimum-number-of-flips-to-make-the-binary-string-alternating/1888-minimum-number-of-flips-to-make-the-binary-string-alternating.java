class Solution {
    public int minFlips(String s) {
        int length = s.length();
        s = s + s;
        StringBuilder alternatingOne = new StringBuilder();
        StringBuilder alternatingZero = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            alternatingOne.append(i % 2 == 0 ? '1' : '0');
            alternatingZero.append(i % 2 == 0 ? '0' : '1');
        }

        int leftIndex = 0;
        int rightIndex = 0;

        int altOneDiff = 0;
        int altZeroDiff = 0;
        int min = Integer.MAX_VALUE;

        while (rightIndex < s.length()) {
            // Update for right
            char rightChar = s.charAt(rightIndex);
            if (rightChar != alternatingOne.charAt(rightIndex)) {
                altOneDiff++;
            }
            if (rightChar != alternatingZero.charAt(rightIndex)) {
                altZeroDiff++;
            }

            // Update for left
            if (rightIndex - leftIndex + 1 > length) {
                char leftChar = s.charAt(leftIndex);
                if (leftChar != alternatingOne.charAt(leftIndex)) {
                    altOneDiff--;
                }
                if (leftChar != alternatingZero.charAt(leftIndex)) {
                    altZeroDiff--;
                }
                leftIndex++;
                
                //update result
                min = Math.min(min, altOneDiff);
                min = Math.min(min, altZeroDiff);
            }

            //Increment
            rightIndex++;
        }
        return min;
    }
}