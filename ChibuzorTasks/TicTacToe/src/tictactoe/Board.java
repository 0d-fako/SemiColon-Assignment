package tictactoe;

public class Board {
    private char[][] board;
    private static final int SIZE = 3;

    public Board() {
        board = new char[SIZE][SIZE];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = '-';
            }
        }
    }

    public boolean placeMark(int row, int col, char mark) {
        if (row >= 0 && col >= 0 && row < SIZE && col < SIZE && board[row][col] == '-') {
            board[row][col] = mark;
            return true;
        }
        return false;
    }

    public boolean checkWin(char mark) {
   
        return (checkRows(mark) || checkColumns(mark) || checkDiagonals(mark));
    }

    private boolean checkRows(char mark) {
        for (int i = 0; i < SIZE; i++) {
            if (board[i][0] == mark && board[i][1] == mark && board[i][2] == mark) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns(char mark) {
        for (int j = 0; j < SIZE; j++) {
            if (board[0][j] == mark && board[1][j] == mark && board[2][j] == mark) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals(char mark) {
        return ((board[0][0] == mark && board[1][1] == mark && board[2][2] == mark) ||
                (board[0][2] == mark && board[1][1] == mark && board[2][0] == mark));
    }

    public boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

}
