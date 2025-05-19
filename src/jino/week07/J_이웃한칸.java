package jino.week07;

public class J_이웃한칸 {
    class Solution {
        private static int[] dx = new int[]{-1 , 0 , 1 ,0};//북 동 남 서 열이동
        private static int[] dy = new int[]{0 , 1, 0, -1};
        private static int answer = 0;
        private static String now ="";
        private static int maxX;
        private static int maxY;
        public int solution(String[][] board, int h, int w) {
            maxX = board.length;
            maxY = board[0].length;
            now = board[h][w];
            for(int i = 0 ; i < 4 ; i++){
                int nextX = h + dx[i];
                int nextY = w + dy[i];
                if(nextX >= 0 && nextY >= 0 && nextX < maxX && nextY < maxY){
                    if(now.equals(board[nextX][nextY])){
                        answer++;
                    }
                }
            }
            return answer;
        }
    }
}
