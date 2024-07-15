import java.util.*;

public class LongestPathDAG {

    public static int longestPathDAG(List<Vertex> vertices, List<Edge> edges, Vertex startVertex) {
        Map<Long, List<Vertex>> graph = new HashMap<>();
        for (Vertex v : vertices) {
            graph.put(v.id, new ArrayList<>());
        }
        for (Edge edge : edges) {
            graph.get(edge.from.id).add(edge.to);
        }

        List<Long> topoSort = topologicalSort(vertices, graph);
        Map<Long, Integer> dp = new HashMap<>();
        for (Vertex v : vertices) {
            dp.put(v.id, Integer.MIN_VALUE);
        }
        dp.put(startVertex.id, 0);

        for (Long u : topoSort) {
            if (dp.get(u) != Integer.MIN_VALUE) {
                for (Vertex v : graph.get(u)) {
                    if (dp.get(v.id) < dp.get(u) + 1) {
                        dp.put(v.id, dp.get(u) + 1);
                    }
                }
            }
        }

        int maxDistance = 0;
        for (int distance : dp.values()) {
            if (distance > maxDistance) {
                maxDistance = distance;
            }
        }

        return maxDistance;
    }

    private static List<Long> topologicalSort(List<Vertex> vertices, Map<Long, List<Vertex>> graph) {
        Set<Long> visited = new HashSet<>();
        Stack<Long> stack = new Stack<>();
        for (Vertex v : vertices) {
            if (!visited.contains(v.id)) {
                topologicalSortUtil(v.id, visited, stack, graph);
            }
        }

        List<Long> topoSort = new ArrayList<>();
        while (!stack.isEmpty()) {
            topoSort.add(stack.pop());
        }

        return topoSort;
    }

    private static void topologicalSortUtil(Long v, Set<Long> visited, Stack<Long> stack, Map<Long, List<Vertex>> graph) {
        visited.add(v);
        for (Vertex neighbour : graph.get(v)) {
            if (!visited.contains(neighbour.id)) {
                topologicalSortUtil(neighbour.id, visited, stack, graph);
            }
        }
        stack.push(v);
    }

    public static void main(String[] args) {
        // Test case in main method
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);

        List<Vertex> vertices = Arrays.asList(v1, v2, v3, v4, v5);
        List<Edge> edges = Arrays.asList(
            new Edge(v1, v2),
            new Edge(v1, v3),
            new Edge(v3, v4),
            new Edge(v4, v5),
            new Edge(v2, v5)
        );

        Vertex startVertex = v1;
        int result = longestPathDAG(vertices, edges, startVertex);
        System.out.println("Longest path length from vertex " + startVertex.id + " is: " + result);
    }
}
