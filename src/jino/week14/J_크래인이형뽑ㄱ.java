package jino.week14;

import java.util.ArrayDeque;
import java.util.Deque;

public class J_크래인이형뽑ㄱ {


    class Solution {
        private static int answer = 0;
        private static Deque<Integer> dq;
        public int solution(int[][] board, int[] moves) {
            dq = new ArrayDeque<>();
            for(int now : moves){
                now -= 1;
                int peek = 0;
                for(int i = 0 ; i < board.length ; i++){
                    if(board[i][now] > 0){
                        peek = board[i][now];
                        board[i][now] = 0;
                        break;
                    }

                }
                if(peek == 0){
                    continue;
                }
                if(dq.isEmpty()){
                    dq.push(peek);
                }else if(!dq.isEmpty() && dq.peek() == peek){
                    dq.pop();
                    answer++;
                }else{
                    dq.push(peek);
                }

            }
            return answer * 2;
        }
    }
}
