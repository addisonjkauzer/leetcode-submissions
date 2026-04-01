class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        final int[] sortedPiles = Arrays.copyOf(piles, piles.length);
        Arrays.sort(sortedPiles);

        Integer leftNumber = 1;
        Integer rightNumber = sortedPiles[sortedPiles.length - 1];

        Integer minK = rightNumber;

        while (leftNumber <= rightNumber) {
            final Integer middleNumber = leftNumber + (rightNumber - leftNumber) / 2;
            final Integer timeToEat = this.hoursToEat(sortedPiles, middleNumber);

            if (h >= timeToEat) {
                rightNumber = middleNumber - 1;
                minK = Math.min(minK, middleNumber);
            } else {
                leftNumber = middleNumber + 1;
            }
        }

        return minK;
    }

    public int hoursToEat(int[] piles, int k) {
        Integer hours = 0;
        for (final Integer pile : piles) {
            hours += pile/k;
            if (pile % k != 0) {
                hours += 1;
            }
        }
        return hours;
    }
}
