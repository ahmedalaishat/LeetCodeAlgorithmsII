package all_paths_from_source_to_target_797;

import java.util.*;

/**
 * Created by Ahmed Al-Aishat on Jul/23/2023.
 * LeetCode Algorithm II Project.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().allPathsSourceTarget(new int[][]{{1, 2}, {3,}, {3}, {}}));
    }

    List<List<Integer>> ans = new ArrayList<>();
    int[][] graph;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.graph = graph;
        findPath(0, new ArrayList<>());
        return ans;
    }

    public void findPath(int node, List<Integer> path) {
        List<Integer> current = new ArrayList<>(path);
        current.add(node);

        if (node == graph.length - 1)
            ans.add(current);

        else for (int i = 0; i < graph[node].length; i++)
            findPath(graph[node][i], current);
    }
}
