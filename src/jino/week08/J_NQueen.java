package jino.week08;

public class J_NQueen {
    class Solution {
        private static int answer;
        private static int N;
        private static int[] chessMap;

        public int solution(int n) {
            //초기화
            answer = 0;
            N = n;
            chessMap = new int[n];
            chess(0);
            return answer;
        }
        private static void chess(int num){
            if(num == N){
                answer++;
                return;
            }
            for(int i = 0 ; i < N ; i++){
                chessMap[num] = i;
                if(possible(num)){
                    chess(num + 1);
                }
            }
        }
        private static boolean possible(int num){
            //가로 검사
            for(int i = 0 ; i < num ; i++){
                if(chessMap[num] == chessMap[i]){
                    return false;
                }
            }

            //대각선 검사
            for(int i = 0 ; i < num ; i++){
                if(Math.abs(num - i) == Math.abs(chessMap[num] - chessMap[i])){
                    return false;
                }

            }
            return true;
        }
    }
}
