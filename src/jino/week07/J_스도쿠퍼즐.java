package jino.week07;

import java.util.Arrays;

public class J_스도쿠퍼즐 {

    // The main method must be in a class named "Main".
    class Main {
        private static int[][] board = new int[9][9];
        public static void main(String[] args) {
            int[][] board1 = {
                    {5, 3, 0, 0, 7, 0, 0, 0, 0},
                    {6, 0, 0, 1, 9, 5, 0, 0, 0},
                    {0, 9, 8, 0, 0, 0, 0, 6, 0},
                    {8, 0, 0, 0, 6, 0, 0, 0, 3},
                    {4, 0, 0, 8, 0, 3, 0, 0, 1},
                    {7, 0, 0, 0, 2, 0, 0, 0, 6},
                    {0, 6, 0, 0, 0, 0, 2, 8, 0},
                    {0, 0, 0, 4, 1, 9, 0, 0, 5},
                    {0, 0, 0, 0, 8, 0, 0, 7, 9}
            };
            System.out.println(Arrays.deepToString(solution(board1)));

            int[][] board2 = {
                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0}
            };
            System.out.println(Arrays.deepToString(solution(board2)));


        }
        private static int[][] solution(int[][] map){
            // board에 map 값 복사
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    board[i][j] = map[i][j];
                }
            }
            findSol();
            return board;
        }

        private static class Block{
            int i,j;
            public Block(int i, int j){
                this.i = i;
                this.j = j;
            }
        }

        private static boolean inRow(int num, int row){//행에 num이 있나 확인
            for(int i = 0 ; i < 9 ;i++){
                if(board[row][i] == num){
                    return true;
                }
            }
            return false;
        }

        private static boolean inCol(int num, int col){//열에 num이 있나 확인
            for(int i = 0 ; i < 9 ;i++){
                if(board[i][col] == num){
                    return true;
                }
            }
            return false;
        }

        private static boolean inBox(int num, int row, int col){
            int boxRow = (row / 3) * 3;// 4 면 > 3이 나옴
            int boxCol = (col / 3) * 3;
            for(int i = boxRow ; i < boxRow + 3 ; i++){
                for(int j = boxCol ; j < boxCol + 3; j++){
                    if(board[i][j] == num){
                        return true;
                    }
                }
            }
            return false;
        }

        // isValid 메소드 추가
        private static boolean isValid(int num, int row, int col) {
            return !(inRow(num, row) || inCol(num, col) || inBox(num, row, col));
        }

        private static Block findEmpty(){
            for(int i = 0 ; i < 9 ; i++){
                for(int j = 0 ; j < 9 ; j++){
                    if(board[i][j] == 0){
                        return new Block(i, j);
                    }
                }
            }
            return null;
        }

        private static boolean findSol(){
            Block emp = findEmpty();
            if(emp == null){
                return true;
            }//다 0 변경함
            int row = emp.i;
            int col = emp.j;
            for(int num = 1; num <= 9; num++){
                if(isValid(num, row, col)){
                    board[row][col] = num;
                    if(findSol()){
                        return true;
                    }
                    board[row][col] = 0;
                }
            }
            return false;
        }
    }

}
