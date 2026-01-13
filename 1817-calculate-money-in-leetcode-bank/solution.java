class Solution {
    final static Integer FIRST_WEEK = 1 + 2 + 3 + 4 + 5 + 6 + 7;
    final static Integer WEEK_MULTIPLIER = 7;
    public int totalMoney(int n) {
        Integer numberOfFullWeeks = n / 7;
        Integer basePay = FIRST_WEEK * numberOfFullWeeks;

        for (int i = 0; i < numberOfFullWeeks; i++) {
            basePay += WEEK_MULTIPLIER * i;
        }

        Integer remainderDays = n % 7;
        for (int i = 0; i < remainderDays; i++) {
            basePay += i + (numberOfFullWeeks + 1);
        }




        return basePay;
    }
}