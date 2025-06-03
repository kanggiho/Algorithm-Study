package heonwoo.week06;
import java.util.Arrays;

public class H44_스도쿠퍼즐 {
    private static class Block {
        int i, j;
        public Block(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    private static int[][] Board;

    private static boolean isValid(int num, int row, int col) {
        return !(inRow(num, row) || inCol(num, col) || inBox(num, row, col));
    }

    private static boolean inRow(int num, int row) {
        return Arrays.stream(Board[row]).anyMatch(i -> i == num);
    }

    private static boolean inCol(int num, int col) {
        for (int i = 0; i < 9; i++) {
            if (Board[i][col] == num) return true;
        }
        return false;
    }

    private static boolean inBox(int num, int row, int col) {
        // 현재 위치의 3x3 박스에 num이 있는지 확인
        int boxRow = (row / 3) *3;
        int boxCol = (col / 3) *3;

        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (Board[i][j] == num) {
                    return true;
                }
            }
        }
        return false;
    }

    private static Block findEmptyPosition() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (Board[i][j] == 0) return new Block(i,j);
            }
        }
        return null;
    }

    private static boolean findSolution() {
        // 비어 있는 위치에 가능한 숫자를 넣어가며 스도쿠 해결
        Block emptyPos = findEmptyPosition();
        // 빈칸이 없으면 스도쿠가 해결된 것으로 간주
        if (emptyPos == null)
            return true;

        int row = emptyPos.i;
        int col = emptyPos.j;

        for (int num = 1; num <= 9; num++) {
            if (isValid(num, row, col)) {
                Board[row][col] = num;
                // 다음 빈칸을 재귀 탐색
                if (findSolution()) {
                    return true;
                }
                // 가능한 숫자가 없으면 원래의 0으로 되돌림
                Board[row][col] = 0;
            }
        }
        return false;
    }

    private static int[][] solution(int[][] board) {
        Board = board;
        findSolution();
        return board;
    }
}
