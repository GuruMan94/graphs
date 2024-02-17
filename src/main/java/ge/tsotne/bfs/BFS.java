package ge.tsotne.bfs;

import ge.tsotne.model.Graph;
import ge.tsotne.model.Vertex;

import java.util.*;

/*
    Time complexity: O(V+E) where V represents the number of vertices and E represents the number of edges in the graph
    Space complexity: O(w) where w is the maximum width of the tree.
 */
public class BFS<T> {

    public static void main(String[] args) {
        Graph<String> graph = new Graph<>().createGraph();
        System.out.println(new BFS<String>().breadthFirstTraversal(graph, "Bob"));
    }

    public Set<T> breadthFirstTraversal(Graph<T> graph, T root) {
        Set<T> visited = new HashSet<>();
        Queue<T> queue = new LinkedList<>();
        queue.add(root);
        visited.add(root);
        while (!queue.isEmpty()) {
            T vertex = queue.poll();
            for (Vertex<T> v : graph.getAdjVertices(vertex)) {
                if (!visited.contains(v.getValue())) {
                    visited.add(v.getValue());
                    queue.add(v.getValue());
                }
            }
        }
        return visited;
    }
}
