package heonwoo.week09;

public class H75_가장큰정사각형찾기 {
    public int solution(int[][] board) {
        int row = board.length; // 행
        int col = board[0].length; // 열

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (board[i][j] == 1) {
                    int up = board[i - 1][j];
                    int left = board[i][j - 1];
                    int upLeft = board[i - 1][j - 1];
                    // 현재 위치의 값을 이전 위치들의 값들 중
                    // 가장 작은 값에 1을 더한 값으로 업데이트
                    board[i][j] = Math.min(Math.min(up, left), upLeft) + 1;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                answer = Math.max(answer, board[i][j]);
            }
        }
        return answer * answer;
    }
}
