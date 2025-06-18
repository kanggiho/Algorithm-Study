package giho.week07;

public class G75_가장큰정사각형찾기 {
    public int solution(int[][] board) {

        int answer = 0;
        int x = board.length;
        int y = board[0].length;
        int[][] map = new int[x + 1][y + 1];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                map[i + 1][j + 1] = board[i][j];
            }
        }

        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                if (map[i][j] != 0) {
                    map[i][j] = Math.min(Math.min(map[i - 1][j], map[i][j - 1]), map[i - 1][j - 1]) + 1;
                    answer = Math.max(answer, map[i][j]);
                }
            }
        }

        return answer * answer;
    }
}
