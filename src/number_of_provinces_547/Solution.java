package number_of_provinces_547;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Ahmed Al-Aishat on Jul/21/2023.
 * LeetCode Algorithm II Project.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().findCircleNum(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
    }

    boolean[] visited;
    int[][] isConnected;

    public int findCircleNum(int[][] isConnected) {
        visited = new boolean[isConnected.length];
        this.isConnected = isConnected;
        int provincesCount = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i]) continue;
            provincesCount++;
            visit(i);
        }
        return provincesCount;
    }

    public void visit(int n) {
        visited[n] = true;
        for (int i = 0; i < isConnected.length; i++)
            if (isConnected[n][i] == 1 && !visited[i])
                visit(i);
    }
}
