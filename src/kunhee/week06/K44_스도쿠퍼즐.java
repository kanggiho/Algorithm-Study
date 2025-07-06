package kunhee.week06;

public class K44_스도쿠퍼즐 {

    public int[][] solution(int[][] board) {
        solve(board);
        return board;
    }

    private boolean solve(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    // 1부터 9까지 시도
                    for (int i = 1; i <= 9; i++) {
                        if (isValid(board, row, col, i)) {
                            board[row][col] = i;

                            if (solve(board)) return true;

                            board[row][col] = 0; // 백트래킹
                        }
                    }
                    return false; // 1~9 아무 숫자도 못 넣으면 실패
                }
            }
        }
        return true; // 다 채워졌으면 성공
    }

    private boolean isValid(int[][] board, int row, int col, int num) {
        // 행, 열 검사
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num)
                return false;
        }

        // 3x3 박스 검사
        int startRow = row / 3 * 3;
        int startCol = col / 3 * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num)
                    return false;
            }
        }

        return true;
    }

}
