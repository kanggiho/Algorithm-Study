package jino.week13;

import java.util.ArrayDeque;
import java.util.Deque;

public class J12_주식가격 {

    class Solution {
        public int[] solution(int[] prices) {
            int[] answer = new int[prices.length];
            Deque<Integer> dq = new ArrayDeque<>();
            int time = 0;
            dq.add(time);
            for(time = 1 ; time <  prices.length ; time++){
                while(!dq.isEmpty() && prices[dq.peek()] > prices[time]){
                    int index = dq.pop();
                    answer[index] = time - index;
                }
                dq.push(time);
            }

            while(!dq.isEmpty()){
                int index = dq.pop();
                answer[index] = time - index - 1;
            }

            return answer;
        }
    }
}
