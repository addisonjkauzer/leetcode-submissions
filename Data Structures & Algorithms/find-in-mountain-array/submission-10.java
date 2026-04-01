/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peakIndex = findPeak(mountainArr);
        int leftSearch = binarySearch(0, peakIndex, target, mountainArr);
        if (leftSearch == -1) {
            return invertedBinarySearch(peakIndex, mountainArr.length() - 1, target, mountainArr);
        }
        return leftSearch;
    }

    public int binarySearch(int left, int right, int target, MountainArray mntArray) {
        while (left <= right) {
            int middle = left + (right - left) / 2;
            int midValue = mntArray.get(middle);
            if (target < midValue) {
                right = middle - 1;
            } else if (target > midValue) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public int invertedBinarySearch(int left, int right, int target, MountainArray mntArray) {
        while (left <= right) {
            int middle = left + (right - left) / 2;
            int midValue = mntArray.get(middle);
            if (target > midValue) {
                right = middle - 1;
            } else if (target < midValue) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public int findPeak(MountainArray mntArray) {
        int left = 0;
        int right = mntArray.length() - 1;
        int solution = 0;
        while (left < right) {
            int middle = left + (right - left) / 2;
            System.out.println(left + "," +  middle + "," + right);
            int leftVal = mntArray.get(middle - 1);
            int middleVal = mntArray.get(middle);
            int rightVal = mntArray.get(middle + 1);
            if (leftVal < middleVal && middleVal > rightVal) {
                return middle;
            }
            if (leftVal < rightVal) {
                left = middle + 1;
                solution = left;
            } else {
                right = middle - 1;
                solution = right;
            }
        }
        return solution;
    }
}