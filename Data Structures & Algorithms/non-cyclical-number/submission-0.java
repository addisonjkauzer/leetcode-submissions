class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> duplicateChecker = new HashSet<>();
        while (n != 1) {
            String nString = Integer.toString(n);
            Integer newSum = 0;
            for (char number : nString.toCharArray()) {
                newSum += Character.getNumericValue(number) * Character.getNumericValue(number);
            }
            System.out.println(newSum);
            if (duplicateChecker.contains(newSum)) {
                return false;
            }
            duplicateChecker.add(newSum);
            n = newSum;
        }
        return true;
    }
}
