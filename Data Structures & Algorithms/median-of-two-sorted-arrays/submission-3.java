class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1;
        int[] B = nums2;
        if (B.length < A.length) {
            int[] temp = B;
            B = A;
            A = temp;
        }

        int totalLength = A.length + B.length;
        int halfLength = (totalLength + 1) / 2;

        int left = 0;
        int right = A.length;

        while (left <= right) {
            int AMiddle = left + (right - left) / 2;
            int BMiddle = halfLength - AMiddle;

            int ALeft = AMiddle > 0 ? A[AMiddle - 1] : Integer.MIN_VALUE;
            int ARight = AMiddle < A.length ? A[AMiddle] : Integer.MAX_VALUE;
            int BLeft = BMiddle > 0 ? B[BMiddle - 1] : Integer.MIN_VALUE;
            int BRight = BMiddle < B.length ? B[BMiddle] : Integer.MAX_VALUE;

            if (ALeft <= BRight && BLeft <= ARight) {
                if (totalLength % 2 == 0) {
                    return (Math.max(ALeft, BLeft) + Math.min(ARight, BRight)) / 2.0;
                } else {
                    return Math.max(ALeft, BLeft);
                }
            } else if (ALeft > BRight) {
                right = AMiddle - 1;
            } else {
                left = AMiddle + 1;
            }
        }
        return -1;
    }
}
