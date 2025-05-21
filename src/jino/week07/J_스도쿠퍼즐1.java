package jino.week07;

import java.util.Arrays;

public class J_스도쿠퍼즐1 {


    // The main method must be in a class named "Main".
    class Main {
        private static int[][] board;
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
        private static int[][] solution(int[][] arr){
            board = arr;
            sudoku(0, 0);
            return board;
        }
        private static boolean sudoku(int row, int col){
            if(col == 9){
                return sudoku(row + 1 , 0);
            }

            if(row == 9){
                return true;
            }
            if(board[row][col] == 0){
                for(int i = 1 ; i <= 9 ; i++){
                    if(isPossible(row, col, i)){
                        board[row][col] = i;
                        if(sudoku(row, col+1)){
                            return true;
                        }
                    }
                }
                board[row][col] = 0;
                return false;

            }
            return sudoku(row, col + 1);
        }
        private static boolean isPossible(int row, int col, int num){
            //행 판단
            for(int j = 0 ; j < 9 ; j++){
                if(board[row][j] == num){
                    return false;
                }
            }


            //열 판단
            for(int i = 0 ; i < 9 ; i++){
                if(board[i][col] == num){
                    return false;
                }
            }
            //박스 판단
            int boxRow = (row / 3) * 3;
            int boxCol = (col / 3) * 3;
            for(int i = boxRow ; i < boxRow + 3 ; i++){
                for(int j = boxCol ; j < boxCol + 3 ; j++){
                    if(board[i][j] == num){
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
