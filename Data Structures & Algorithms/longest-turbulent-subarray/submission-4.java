class Solution {
    public int maxTurbulenceSize(int[] arr) {
        Integer pointer = 0;
        Integer currentLength = 1;
        Integer maxLength = 1;

        if (arr.length == 1) {
            return 1;
        }
        if (arr.length == 0) {
            return 0;
        }
        

        boolean shouldBeGreater = arr[0] > arr[1];

        while (pointer < arr.length - 1) {
            if (arr[pointer] == arr[pointer + 1]) {
                currentLength = 1;
                pointer++;
                if (pointer < arr.length - 1) {
                    shouldBeGreater = arr[pointer] > arr[pointer + 1];
                }
                continue;
            }
            if ((arr[pointer] > arr[pointer + 1] && shouldBeGreater) || 
                 arr[pointer] < arr[pointer + 1] && !shouldBeGreater) {
                pointer++;
                currentLength++;
                shouldBeGreater = !shouldBeGreater;
            } else {
                currentLength = 1;
                shouldBeGreater = arr[pointer] > arr[pointer + 1];
            }
            maxLength = Math.max(maxLength, currentLength);
        }
        return maxLength;
    }
}