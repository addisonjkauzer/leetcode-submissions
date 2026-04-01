class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        tickets.sort((a, b) -> a.get(1).compareTo(b.get(1)));
        HashMap<String, List<String>> edgeMap = new HashMap<>();
        for (List<String> ticket: tickets) {
            List<String> neighbors = edgeMap.getOrDefault(ticket.get(0), new ArrayList<>());
            neighbors.add(ticket.get(1));
            edgeMap.put(ticket.get(0), neighbors);
        }
        List<String> result = new ArrayList<>();
        result.add("JFK");
        dfs(edgeMap, "JFK", result, tickets.size() + 1);
        return result;
    }

    public boolean dfs(HashMap<String, List<String>> edgeMap, 
                    String currentNode,
                    List<String> result,
                    Integer targetLength) {
        if (result.size() == targetLength) {
            return true;
        }
        if (!edgeMap.containsKey(currentNode)) {
            return false;
        }
        List<String> neighbors = new ArrayList<>(edgeMap.get(currentNode));
        for (int i = 0; i < neighbors.size(); i++) {
            String neighbor = neighbors.get(i);
            result.add(neighbor);
            edgeMap.get(currentNode).remove(i);
            if (dfs(edgeMap, neighbor, result, targetLength)) {
                return true;
            }
            result.remove(result.size() - 1);
            edgeMap.get(currentNode).add(i, neighbor);
        }  
        return false;           
    }
}
