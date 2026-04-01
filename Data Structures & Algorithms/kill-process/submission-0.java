class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, Set<Integer>> childMap = new HashMap<>();

        for (int i = 0; i < pid.size(); i++) {
            Integer child = pid.get(i);
            Integer parent = ppid.get(i);
            childMap.computeIfAbsent(parent, a -> new HashSet<>()).add(child);
        }

        System.out.println(childMap);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(kill);
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            result.add(current);
            Set<Integer> newChildren = childMap.getOrDefault(current, new HashSet<>());
            queue.addAll(newChildren);
        }
        return result;
    }
}
