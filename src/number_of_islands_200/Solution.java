package number_of_islands_200;

/**
 * Created by Ahmed Al-Aishat on Jul/21/2023.
 * LeetCode Algorithm II Project.
 */
public class Solution {

    char[][] grid;

    int[] rows = new int[]{-1, 0, 1, 0};
    int[] cols = new int[]{0, 1, 0, -1};


    public int numIslands(char[][] grid) {
        this.grid = grid;
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    removeIsland(i, j);
                }
            }
        }
        return islands;
    }

    private void removeIsland(int r, int c) {
        if (grid[r][c] == '0') return;
        grid[r][c] = '0';

        if (r > 0) removeIsland(r - 1, c);
        if (r < grid.length - 1) removeIsland(r + 1, c);
        if (c > 0) removeIsland(r, c - 1);
        if (c < grid[0].length - 1) removeIsland(r, c + 1);
    }
}
