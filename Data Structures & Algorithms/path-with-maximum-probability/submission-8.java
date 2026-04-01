class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        HashMap<Integer, Set<NodeEdge>> edgeMap = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int startNode = edges[i][0];
            int endNode = edges[i][1];
            double probability = succProb[i];

            NodeEdge edgeToEnd = new NodeEdge(endNode, probability);
            Set<NodeEdge> edgesFromStart = edgeMap.getOrDefault(startNode, new HashSet<>());
            edgesFromStart.add(edgeToEnd);
            edgeMap.put(startNode, edgesFromStart);

            NodeEdge edgeToStart = new NodeEdge(startNode, probability);
            Set<NodeEdge> edgesFromEnd = edgeMap.getOrDefault(endNode, new HashSet<>());
            edgesFromEnd.add(edgeToStart);
            edgeMap.put(endNode, edgesFromEnd);
        }

        PriorityQueue<NodeEdge> heap = new PriorityQueue<>(Collections.reverseOrder(Comparator.comparing(a -> a.getProbability())));
        Set<NodeEdge> startingEdges = edgeMap.getOrDefault(start_node, new HashSet<>());
        heap.addAll(startingEdges);

        Set<Integer> seen = new HashSet<>();
        seen.add(start_node);

        while (!heap.isEmpty()) {
            NodeEdge currentPath = heap.poll();
            seen.add(currentPath.getNode());

            if (currentPath.getNode() == end_node) {
                return currentPath.getProbability();
            }

            Set<NodeEdge> futureEdges = edgeMap.getOrDefault(currentPath.getNode(), new HashSet<>());
            for (NodeEdge futureEdge : futureEdges) {
                if (seen.contains(futureEdge.getNode())) {
                    continue;
                }
                NodeEdge newEdge = new NodeEdge(futureEdge.getNode(), futureEdge.getProbability() * currentPath.getProbability());
                heap.add(newEdge);
            }
        }
        return 0;
    }
}

class NodeEdge {
    public int node;
    public double probability;

    public NodeEdge(int node, double probability) {
        this.node = node;
        this.probability = probability;
    }

    public double getProbability() {
        return this.probability;
    }

    public int getNode() {
        return this.node;
    }

    public void combineWithProb(double newProbability) {
        this.probability = this.probability * newProbability;
    }
}