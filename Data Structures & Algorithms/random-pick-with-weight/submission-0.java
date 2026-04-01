class Solution {
    public int[] probabilityArray;
    
    public Solution(int[] w) {
        int sum = Arrays.stream(w).sum();
        probabilityArray = new int[sum];
        int iterator = 0;
        for (int i = 0; i < w.length; i++) {
            for (int j = 0; j < w[i]; j++) {
                probabilityArray[iterator] = i;
                iterator++;
            }
        }
    }

    public int pickIndex() {
        Random random = new Random();
        int randomIndex = random.nextInt(probabilityArray.length);

        return probabilityArray[randomIndex];
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */