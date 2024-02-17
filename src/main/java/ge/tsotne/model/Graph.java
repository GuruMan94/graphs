package ge.tsotne.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<T> {
    private final Map<Vertex<T>, List<Vertex<T>>> adjVertices = new HashMap<>();

    public void addVertex(T value) {
        adjVertices.putIfAbsent(new Vertex<>(value), new ArrayList<>());
    }

    public void removeVertex(T value) {
        Vertex<T> v = new Vertex<>(value);
        adjVertices.values().forEach(e -> e.remove(v));
        adjVertices.remove(new Vertex<>(value));
    }

    public void addEdge(T value1, T value2) {
        Vertex<T> v1 = new Vertex<>(value1);
        Vertex<T> v2 = new Vertex<>(value2);
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);
    }

    public void removeEdge(T value1, T value2) {
        Vertex<T> v1 = new Vertex<>(value1);
        Vertex<T> v2 = new Vertex<>(value2);
        List<Vertex<T>> eV1 = adjVertices.get(v1);
        List<Vertex<T>> eV2 = adjVertices.get(v2);
        if (eV1 != null)
            eV1.remove(v2);
        if (eV2 != null)
            eV2.remove(v1);
    }

    @Override
    public String toString() {
        return "Graph{" +
                "adjVertices=" + adjVertices +
                '}';
    }

    public Graph<String> createGraph() {
        Graph<String> graph = new Graph<>();
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");
        return graph;
    }

    public List<Vertex<T>> getAdjVertices(T value) {
        return adjVertices.get(new Vertex<>(value));
    }
}
