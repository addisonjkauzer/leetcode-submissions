class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        Integer rowIndex = 0;

        while (target > matrix[rowIndex][0]) {
            rowIndex++;
            if (rowIndex == matrix.length || target < matrix[rowIndex][0]) {
                rowIndex--;
                break;
            }
        }

        final int[] row = matrix[rowIndex];

        Integer leftPointer = 0;
        Integer rightPointer = row.length - 1;

        while (leftPointer <= rightPointer) {
            final Integer middleIndex = leftPointer + (rightPointer - leftPointer) / 2;
            final Integer middleNumber = row[middleIndex];

            if (target > middleNumber) {
                leftPointer = middleIndex + 1;
            } else if (target < middleNumber) {
                rightPointer = middleIndex - 1; 
            } else {
                return true;
            }
        }
        return false;
        
    }
}
