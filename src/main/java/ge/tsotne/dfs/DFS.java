package ge.tsotne.dfs;

import ge.tsotne.model.Graph;
import ge.tsotne.model.Vertex;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/*
    Time complexity: O(V+E) where V represents the number of vertices and E represents the number of edges in the graph
    Space complexity: O(h) where h is the maximum height of the tree
     DFS is more memory efficient than BFS
 */
public class DFS<T> {

    public static void main(String[] args) {
        Graph<String> graph = new Graph<>().createGraph();
        System.out.println(new DFS<String>().depthFirstTraversal(graph, "Bob"));
    }

    public Set<T> depthFirstTraversal(Graph<T> graph, T root) {
        Set<T> visited = new HashSet<>();
        Stack<T> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            T vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Vertex<T> v : graph.getAdjVertices(vertex)) {
                    stack.push(v.getValue());
                }
            }
        }
        return visited;
    }
}
