package word_search_79;

/**
 * Created by Ahmed Al-Aishat on Jul/27/2023.
 * LeetCode Algorithm II Project.
 */
public class Solution {

    public static void main(String[] args) {
        var board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'},
        };

        System.out.println(new Solution().exist(board, "ABCCED"));
    }

    boolean[][] visited;

    int[] dr = {-1, 0, 0, 1};
    int[] dc = {0, -1, 1, 0};

    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == chars[0]) {
                    visited = new boolean[board.length][board[0].length];
                    if (exist(chars, board, 0, i, j)) return true;
                }
            }
        }
        return false;
    }

    public boolean exist(char[] word, char[][] board, int start, int r, int c) {
        if (board[r][c] != word[start]) {
            return false;
        }
        if (start == word.length - 1) return true;
        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            var newR = r + dr[i];
            var newC = c + dc[i];
            if (newR >= 0 && newR < board.length && newC >= 0 && newC < board[0].length && !visited[newR][newC])
                if (exist(word, board, start + 1, newR, newC)) return true;
        }
        visited[r][c] = false;
        return false;
    }
}
