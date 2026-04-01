class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] runningTarget = new int[target.length];

        for (int[] triplet : triplets) {
            if (triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]) {
                runningTarget[0] = Math.max(triplet[0], runningTarget[0]);
                runningTarget[1] = Math.max(triplet[1], runningTarget[1]);
                runningTarget[2] = Math.max(triplet[2], runningTarget[2]);
            }
        }
        for (int i = 0; i < target.length; i++) {
            if (target[i] != runningTarget[i]) {
                return false;
            }
        }
        return true;
    }
}
