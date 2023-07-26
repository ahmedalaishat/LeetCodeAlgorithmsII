package surrounded_regions_130;

import java.util.Arrays;

/**
 * Created by Ahmed Al-Aishat on Jul/23/2023.
 * LeetCode Algorithm II Project.
 */
public class Solution {


    public static void main(String[] args) {
        var matrix = new char[][]{
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'}
        };

        new Solution().solve(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    char[][] board;
    boolean[][] shouldKeep;

    public void solve(char[][] board) {
        this.board = board;
        this.shouldKeep = new boolean[board.length][board[0].length];
        // mark all edge connected 'O' to keep it
        for (int i = 0; i < board.length; i++) {
            markToKeep(i, 0);
            markToKeep(i, board[0].length - 1);
        }
        for (int i = 0; i < board[0].length; i++) {
            markToKeep(0, i);
            markToKeep(board.length - 1, i);
        }
        // keep the edges connected 'O's other wise make it 'X'
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!this.shouldKeep[i][j]) this.board[i][j] = 'X';
            }
        }
    }

    private void markToKeep(int r, int c) {
        if (board[r][c] != 'O' || shouldKeep[r][c]) return;
        shouldKeep[r][c] = true;

        if (r > 0) markToKeep(r - 1, c);
        if (r < board.length - 1) markToKeep(r + 1, c);
        if (c > 0) markToKeep(r, c - 1);
        if (c < board[0].length - 1) markToKeep(r, c + 1);
    }
}
