class Solution {
    public boolean checkValidString(String s) {
        Integer leftMin = 0;
        Integer leftMax = 0;

        for (Character character : s.toCharArray()) {
            switch (character) {
                case('('):
                    leftMin++;
                    leftMax++;
                    break;
                case(')'):
                    leftMin--;
                    leftMax--;
                    break;
                case('*'):
                    leftMin--;
                    leftMax++;
                    break;
            }
            if (leftMin < 0) {
                leftMin = 0;
            }
            if (leftMax < 0) {
                return false;
            }
        }
        return leftMin == 0;
    }
}
