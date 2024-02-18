package ge.tsotne.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
    1557. Minimum Number of Vertices to Reach All Nodes
    https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/description/
 */
public class LeetCode1557 {

    /*
        we need to find all vertices where incoming edge count is 0. Because graph is
        acyclic there will be no incoming edges for these vertices
     */
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] visited = new boolean[n];
        for (List<Integer> edge : edges) {
            visited[edge.get(1)] = true;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ans.add(i);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(new LeetCode1557().findSmallestSetOfVertices(6, List.of(List.of(0, 1), List.of(0, 2),
                List.of(2, 5), List.of(3, 4), List.of(4, 2))));
    }
}
