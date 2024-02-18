package ge.tsotne.leetcode;

import java.util.*;

/*
    1971. Find if Path Exists in Graph
    https://leetcode.com/problems/find-if-path-exists-in-graph/description/
 */
public class LeetCode1971 {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) {
            return true;
        }
        Map<Integer, ArrayList<Integer>> adjacentMap = populateAdjacentMap(n, edges);
        return isValidPathByDFS(source, destination, adjacentMap);
    }

    private boolean isValidPathByDFS(int source, int destination, Map<Integer, ArrayList<Integer>> adj) {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        visited.add(source);
        stack.push(source);

        while (!stack.isEmpty()) {
            int curr = stack.pop();
            for (int neighbour : adj.get(curr)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    stack.push(neighbour);
                }
            }
        }
        return visited.contains(destination);
    }

    private Map<Integer, ArrayList<Integer>> populateAdjacentMap(int n, int[][] edges) {
        Map<Integer, ArrayList<Integer>> adj = initializeMap(n);
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return adj;
    }

    private Map<Integer, ArrayList<Integer>> initializeMap(int n) {
        Map<Integer, ArrayList<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        return adj;
    }
}
