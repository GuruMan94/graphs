package ge.tsotne.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/*
    841. Keys and Rooms
    https://leetcode.com/problems/keys-and-rooms/description/
 */
public class LeetCode841 {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int roomsCount = rooms.size();
        Set<Integer> visited = dfs(rooms);
        return visited.size() == roomsCount;
    }

    public Set<Integer> dfs(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (int a : rooms.get(vertex)) {
                    stack.push(a);
                }
            }
        }
        return visited;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode841().canVisitAllRooms(List.of(List.of(1), List.of(2),
                List.of(3), List.of())));
    }
}
