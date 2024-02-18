package ge.tsotne.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
    797. All Paths From Source to Target
    https://leetcode.com/problems/all-paths-from-source-to-target/description/
 */
public class LeetCode797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(graph, 0, new ArrayList<>(List.of(0)), ans);
        return ans;
    }

    private void dfs(int[][] graph, int u, List<Integer> path, List<List<Integer>> ans) {
        if (u == graph.length - 1) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int v : graph[u]) {
            path.add(v);
            dfs(graph, v, path, ans);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode797().allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}}));
    }
}
