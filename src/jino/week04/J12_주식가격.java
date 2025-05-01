package jino.week04;

import java.util.ArrayDeque;
import java.util.Deque;

public class J12_주식가격 {
    class Solution {
        private static Deque<Integer> indexQue;
        private static int time = 0;
        private static int[] answer;

        public int[] solution(int[] prices) {
            final int PSIZE = prices.length;
            indexQue = new ArrayDeque<>();
            answer = new int[PSIZE];

            indexQue.push(time);
            for (time = 1; time < PSIZE; time++) {
                while (!indexQue.isEmpty() && prices[time] < prices[indexQue.peek()]) {
                    int index = indexQue.pop();
                    answer[index] = time - index;
                }
                indexQue.push(time);
            }

            while (!indexQue.isEmpty()) {
                int index = indexQue.pop();
                answer[index] = time - index - 1;
            }
            return answer;
        }
    }
}