class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Integer[]> jobs = new ArrayList<>();
        for (int i = 0; i < startTime.length; i++) {
            jobs.add(new Integer[]{startTime[i], endTime[i], profit[i]});
        }
        jobs.sort(Comparator.comparing(a -> a[0]));

        return dfsJobScheduling(jobs, 0, 0, new HashMap<>());

        
    }

    public int dfsJobScheduling(List<Integer[]> jobs, int index, int previousEndTime, HashMap<Integer, Integer> cache) {
        if (index == jobs.size()) {
            return 0;
        }
        if (cache.containsKey(previousEndTime)) {
            return cache.get(previousEndTime);
        }
        Integer[] job = jobs.get(index);
        int jobStartTime = job[0];
        int jobEndTime = job[1];
        int jobProfit = job[2];

        Integer result = dfsJobScheduling(jobs, index + 1, previousEndTime, cache);
        if (jobStartTime >= previousEndTime) {
            Integer take = jobProfit + dfsJobScheduling(jobs, index + 1, jobEndTime, cache);
            result = Math.max(result, take);
        }
        cache.put(previousEndTime, result);
        return result;
        


    }
}