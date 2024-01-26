package edit_distance_72;

/**
 * Created by Ahmed Al-Aishat on Aug/05/2023.
 * LeetCode Algorithm II Project.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minDistance("pneumonoultramicroscopicsilicovolcanoconiosis", "ultramicroscopically"));
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] cost = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) cost[i][0] = i;
        for (int i = 1; i <= n; i++) cost[0][i] = i;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word1.charAt(i) == word2.charAt(j))
                    cost[i + 1][j + 1] = cost[i][j]; // no operation
                else {
                                                // replace,   delete,               or insert
                    cost[i + 1][j + 1] = Math.min(cost[i][j], Math.min(cost[i][j + 1], cost[i + 1][j])) + 1;
                }
            }
        }
        return cost[m][n];
    }
}
