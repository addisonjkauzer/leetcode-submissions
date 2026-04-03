class SparseVector {

    public HashMap<Integer, Integer> relevantNums;
    
    SparseVector(int[] nums) {
        relevantNums = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                relevantNums.put(i, nums[i]);
            }
        } 
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        HashMap<Integer, Integer> vecNums = vec.relevantNums;
        int result = 0;

        for (int key : relevantNums.keySet()) {
            int localNum = relevantNums.getOrDefault(key, 0);
            int vecNum = vecNums.getOrDefault(key, 0);
            result += localNum * vecNum;
        }
        return result;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
