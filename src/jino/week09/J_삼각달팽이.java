package jino.week09;

public class J_삼각달팽이 {
    class Solution {
        private static int total;
        private static int[] answer;
        private static int[][] snail;
        private static int num = 1;

        public int[] solution(int n) {
            for(int i = 1 ; i <= n ; i++){
                total += i;
            }
            System.out.println(total);
            //초기화
            answer = new int[total];
            snail = new int[n][n];
            int moveCase = 0;
            int col = -1;
            int row = 0;
            int move = n;
            while(num <= total){
                if(moveCase % 3 == 0){//밑으로 이동
                    for(int i = 0 ; i < move ; i++){
                        col++;
                        snail[col][row] = num;
                        num++;
                    }
                    if(col == n){
                        col--;
                    }
                    move--;
                    moveCase++;
                }
                else if(moveCase % 3 == 1){//오른쪽으로 이동
                    for(int i = 0 ; i < move ; i++){
                        row++;
                        snail[col][row] = num;
                        num++;
                    }
                    if(row == n){
                        row--;
                    }
                    move--;
                    moveCase++;
                }
                else if(moveCase % 3 == 2){//대각선 이동
                    for(int i = 0 ; i < move ; i++){
                        row--;
                        col--;
                        snail[col][row] = num;
                        num++;
                    }
                    if(row == n){
                        row--;
                    }
                    if(col == n){
                        col--;
                    }
                    move--;
                    moveCase++;
                }
            }
            int k =0;
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    if(snail[i][j] != 0){
                        answer[k] = snail[i][j];
                        k++;
                    }

                }
            }

            return answer;
        }
    }
}
