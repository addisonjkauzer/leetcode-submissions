class SummaryRanges {

    TreeSet<Integer> numbers; 

    public SummaryRanges() {
        numbers = new TreeSet<>();
        
    }
    
    public void addNum(int value) {
        numbers.add(value);
    }
    
    public int[][] getIntervals() {
        
        List<Integer[]> result = new ArrayList<>();
        for (Integer number : numbers) {
            if (!result.isEmpty() && result.getLast()[1] == number - 1) {
                result.getLast()[1] = number;
            } else {
                result.add(new Integer[]{number, number});
            }
        }

        return result.stream().map(a -> Arrays.stream(a).mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);

    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */