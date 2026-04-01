class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final int[] largerArray;
        final int[] smallerArray;
        if (nums1.length >= nums2.length) {
            largerArray = nums1;
            smallerArray = nums2;
        } else {
            largerArray = nums2;
            smallerArray = nums1;
        }

        final Integer totalLength = smallerArray.length + largerArray.length;
        final Integer halfTotalLength = (totalLength + 1) /  2;


        Integer leftPointer = 0;
        Integer rightPointer = smallerArray.length;

        while (leftPointer <= rightPointer) {
            final Integer smallerArrayMiddlePointer = (leftPointer + rightPointer) / 2;
            final Integer largerArrayMiddlePointer = halfTotalLength - smallerArrayMiddlePointer;
            
            final Integer smallerArrayMiddleValue = smallerArrayMiddlePointer < smallerArray.length ? smallerArray[smallerArrayMiddlePointer] : Integer.MAX_VALUE;
            final Integer smallerArrayLeftOfMiddleValue = smallerArrayMiddlePointer > 0 ? smallerArray[smallerArrayMiddlePointer - 1] : Integer.MIN_VALUE;
            final Integer largerArrayMiddleValue = largerArrayMiddlePointer < largerArray.length ? largerArray[largerArrayMiddlePointer] : Integer.MAX_VALUE;
            final Integer largerArrayLeftOfMiddleValue = largerArrayMiddlePointer > 0 ? largerArray[largerArrayMiddlePointer - 1] : Integer.MIN_VALUE;
            
            

            if (smallerArrayLeftOfMiddleValue > largerArrayMiddleValue) {
                rightPointer = smallerArrayMiddlePointer - 1;
            } else if (largerArrayLeftOfMiddleValue > smallerArrayMiddleValue) {
                leftPointer = smallerArrayMiddlePointer + 1;
            } else {
                if (totalLength % 2 == 0) {
                    return (Math.max(smallerArrayLeftOfMiddleValue, largerArrayLeftOfMiddleValue) + Math.min(smallerArrayMiddleValue, largerArrayMiddleValue)) / 2.0;
                } else {
                    return Math.max(smallerArrayLeftOfMiddleValue, largerArrayLeftOfMiddleValue);
                }
            }
        }
        return -1;
    }
}
