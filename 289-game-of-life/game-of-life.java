class Solution {
    public void gameOfLife(int[][] board) {

        int row = board.length;
        int col = board[0].length;


        int[][] life = new int[board.length][board[0].length];
        int condi = 0;

        if (row == 1 && col == 1) {
            life[0][0] = checkLife(condi, board[0][0]);
        }
        if (row == 1 && col > 1) {
            for (int i = 0; i < board[0].length; i++) {
                if (i == 0) {
                    life[0][i] = checkLife(board[0][i + 1], board[0][i]);
                }
                if (i > 0 && i < board[0].length - 1) {
                    life[0][i] = checkLife((board[0][i + 1] + board[0][i - 1]), board[0][i]);
                }
                if (i == board[0].length - 1) {
                    life[0][i] = checkLife(board[0][i - 1], board[0][i]);
                }
            }
        }
        if (col == 1 && row > 1) {
            for (int i = 0; i < board.length; i++) {
                if (i == 0) {
                    life[i][0] = checkLife(board[i + 1][0], board[i][0]);
                }
                if (i > 0 && i < board.length - 1) {
                    life[i][0] = checkLife((board[i + 1][0] + board[i - 1][0]), board[i][0]);
                }
                if (i == board.length - 1) {
                    life[i][0] = checkLife(board[i - 1][0], board[i][0]);
                }
            }
        }
        if (row > 1 && col > 1) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (i == 0 && j == 0) {

                        condi = board[i][j + 1] + board[i + 1][j + 1] + board[i + 1][j];
                        life[i][j] = checkLife(condi, board[i][j]);

                    } else if (i == board.length - 1 && j == 0) {

                        condi = board[i][j + 1] + board[i - 1][j + 1] + board[i - 1][j];
                        life[i][j] = checkLife(condi, board[i][j]);

                    } else if (i == board.length - 1 && j == board[0].length - 1) {

                        condi = board[i][j - 1] + board[i - 1][j - 1] + board[i - 1][j];
                        life[i][j] = checkLife(condi, board[i][j]);

                    } else if (i == 0 && j == board[0].length - 1) {

                        condi = board[i][j - 1] + board[i + 1][j - 1] + board[i + 1][j];
                        life[i][j] = checkLife(condi, board[i][j]);

                    } else if (i == 0 && j > 0 && j < board[0].length - 1) {

                        condi = board[i][j + 1] + board[i][j - 1] + board[i + 1][j + 1] + board[i + 1][j]
                                + board[i + 1][j - 1];
                        life[i][j] = checkLife(condi, board[i][j]);

                    } else if (j == 0 && i > 0 && i < board.length - 1) {

                        condi = board[i - 1][j] + board[i - 1][j + 1] + board[i][j + 1] + board[i + 1][j + 1]
                                + board[i + 1][j];
                        life[i][j] = checkLife(condi, board[i][j]);

                    } else if (i == board.length - 1 && j > 0 && j < board[0].length - 1) {

                        condi = board[i][j - 1] + board[i - 1][j - 1] + board[i - 1][j] + board[i - 1][j + 1]
                                + board[i][j + 1];
                        life[i][j] = checkLife(condi, board[i][j]);

                    } else if (j == board[0].length - 1 && i > 0 && i < board.length - 1) {

                        condi = board[i - 1][j] + board[i - 1][j - 1] + board[i][j - 1] + board[i + 1][j - 1]
                                + board[i + 1][j];
                        life[i][j] = checkLife(condi, board[i][j]);

                    } else {

                        condi = board[i - 1][j - 1] + board[i - 1][j] + board[i - 1][j + 1] + board[i][j + 1]
                                + board[i + 1][j + 1] + board[i + 1][j] + board[i + 1][j - 1] + board[i][j - 1];
                        life[i][j] = checkLife(condi, board[i][j]);
                    }
                }
            }

        }
        for (int i = 0; i < life.length; i++) {
            board[i] = Arrays.copyOf(life[i], life[i].length);
        }
    }

    public int checkLife(int cond, int val) {
        if (val == 1 && cond < 2) {
            return 0;
        }
        if (val == 1 && cond == 2 || cond == 3) {
            return 1;
        }
        if (val == 1 && cond > 3) {
            return 0;
        }
        if (val == 0 && cond == 3) {
            return 1;
        }
        return val;
    }

}