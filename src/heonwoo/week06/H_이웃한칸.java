package heonwoo.week06;

public class H_이웃한칸 {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};
        String color = board[h][w];
        for (int k = 0; k < 4; k++) {
            h = h + dh[k];
            w = w + dw[k];
            if (h < 0 || h >= board.length || w < 0 || w >= board[h].length) {
                h = h - dh[k];
                w = w - dw[k];
                continue;
            }
            if (color.equals(board[h][w])) {
                answer++;
            }
            h = h - dh[k];
            w = w - dw[k];
        }
        return answer;
    }
}
