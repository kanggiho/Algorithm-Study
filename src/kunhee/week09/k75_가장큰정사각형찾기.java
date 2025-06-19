package kunhee.week09;

// https://school.programmers.co.kr/learn/courses/30/lessons/12905

public class k75_가장큰정사각형찾기 {

    public static int solution(int [][]board) {
        int n = board.length;
        int m = board[0].length;
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1 && i > 0 && j > 0) {
                    board[i][j] = Math.min(Math.min(board[i-1][j], board[i][j-1]), board[i-1][j-1]) + 1;
                }
                max = Math.max(max, board[i][j]);
            }
        }

        return max * max;
    }

    // 테스트
    public static void main(String[] args) {
        int[][] board1 = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
        System.out.println(solution(board1));
        int[][] board2 = {{0,0,1,1},{1,1,1,1}};
        System.out.println(solution(board2));
    }
}