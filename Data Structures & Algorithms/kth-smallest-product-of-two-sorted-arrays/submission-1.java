class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        int num1FirstPositive = binarySearch(nums1);
        int num2FirstPositive = binarySearch(nums2);

        long left = -10_000_000_000L, right = 10_000_000_000L;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long count = countProductsSmallerThan(nums1, nums2, num1FirstPositive, num2FirstPositive, mid);
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;

        

    }

    public long countProductsSmallerThan(int[] nums1, int[] nums2, int num1FirstPositive, int num2FirstPositive, long product) {
        long count = 0;

        int i = 0;
        int j = num2FirstPositive - 1;

        while (i < num1FirstPositive && j >= 0) {
            long testProduct = (long)nums1[i] * nums2[j];
            if (testProduct > product) {
                i++;
            } else {
                count += num1FirstPositive - i;
                j--;
            }
        }

        i = num1FirstPositive;
        j = nums2.length - 1;

        while (i < nums1.length && j >= num2FirstPositive) {
            long testProduct = (long)nums1[i] * nums2[j];
            if (testProduct > product) {
                j--;
            } else {
                count += j - num2FirstPositive + 1;
                i++;
            }
        }

        i = 0;
        j = num2FirstPositive;
        while (i < num1FirstPositive && j < nums2.length) {
            long testProduct = (long)nums1[i] * nums2[j];
            if (testProduct > product) {
                j++;
            } else {
                count += nums2.length - j;
                i++;
            }
        }

        i = num1FirstPositive;
        j = 0;
        while (i < nums1.length && j < num2FirstPositive) {
            long testProduct = (long)nums1[i] * nums2[j];
            if (testProduct > product) {
                i++;
            } else {
                count += nums1.length - i;
                j++;
            }
        }
        return count;
    }

    public int binarySearch(int[] nums) {
        int left = 0;
        int right = nums.length;
        int result = nums.length;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] < 0) {
                left = middle + 1;
            } else if (nums[middle] > 0) {
                right = middle;
            } else {
                return middle;
            }
        }
        return left;
    }
}