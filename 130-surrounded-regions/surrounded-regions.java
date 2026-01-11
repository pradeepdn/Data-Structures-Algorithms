class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') callDFS(board, i, 0);
            if (board[i][cols - 1] == 'O') callDFS(board, i, cols - 1);
        }
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') callDFS(board, 0, j);
            if (board[rows - 1][j] == 'O') callDFS(board, rows - 1, j);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'S') {
                    board[i][j] = 'O';
                }
                else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void callDFS(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'S';

        callDFS(board, i - 1, j);
        callDFS(board, i + 1, j);
        callDFS(board, i, j - 1);
        callDFS(board, i, j + 1);
    }
}