class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        Integer[] minOfArrays = new Integer[]{Integer.MAX_VALUE, -1};
        Integer[] secondMin = new Integer[]{Integer.MAX_VALUE, -1};
        Integer[] maxOfArrays = new Integer[]{Integer.MIN_VALUE, -1};
        Integer[] secondMax = new Integer[]{Integer.MIN_VALUE, -1};
        for (int i = 0; i < arrays.size(); i++) {
            List<Integer> array = arrays.get(i);
            int min = array.get(0);
            int max = array.get(array.size() - 1);
            if (min <= minOfArrays[0]) {
                secondMin = minOfArrays;
                minOfArrays = new Integer[]{min, i};
            } else if (min <= secondMin[0]) {
                secondMin = new Integer[]{min, i};
            }
            if (max >= maxOfArrays[0]) {
                secondMax = maxOfArrays;
                maxOfArrays = new Integer[]{max, i};
            } else if (max >= secondMax[0]) {
                secondMax = new Integer[]{max, i};
            }
        }

        if (minOfArrays[1] != maxOfArrays[1]) {
            return maxOfArrays[0] - minOfArrays[0];
        } else {
            int option1 = maxOfArrays[0] - secondMin[0];
            int option2 = secondMax[0] - minOfArrays[0];
            return Math.max(option1, option2);
        }
    }
}
