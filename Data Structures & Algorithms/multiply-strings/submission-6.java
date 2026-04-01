class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] result = new int[num1.length() + num2.length()];

        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();

        for (int num1Index = 0; num1Index < num1.length(); num1Index++) {
            for (int num2Index = 0; num2Index < num2.length(); num2Index++) {
                Integer totalSum = Character.getNumericValue(num1.charAt(num1Index)) * Character.getNumericValue(num2.charAt(num2Index));
                result[num1Index + num2Index] += totalSum;
                result[num1Index + num2Index + 1] += result[num1Index + num2Index] / 10;
                result[num1Index + num2Index] %= 10;
            }
        }

        StringBuilder resultString = new StringBuilder();
        Integer resultIndex = result.length - 1;
        while (resultIndex >= 0 && result[resultIndex] == 0) {
            resultIndex--;
        }
        while (resultIndex >= 0) {
            resultString.append(result[resultIndex]);
            resultIndex--;
        }
        return resultString.toString();
        
    }
}
