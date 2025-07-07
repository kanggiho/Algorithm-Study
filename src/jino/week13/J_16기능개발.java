package jino.week13;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class J_16기능개발 {



    class Solution {
        private static List<Integer> answerList;
        private static int[] answer;
        private static Deque<Integer> pdq;
        private static Deque<Integer> sdq;
        public int[] solution(int[] progresses, int[] speeds) {
            answerList = new ArrayList<>();
            pdq = new ArrayDeque<>();
            sdq = new ArrayDeque<>();

            for(int i = 0 ; i < progresses.length ; i++){
                pdq.add(progresses[i]);
                sdq.add(speeds[i]);
            }
            // System.out.println(pdq.peek());

            while(!pdq.isEmpty()){
                for(int i = 0 ; i < pdq.size() ; i++){
                    int p = pdq.poll();
                    int s = sdq.poll();

                    pdq.add(p + s);
                    sdq.add(s);
                }
                int count = 0;

                while(!pdq.isEmpty() && pdq.peek() >= 100){

                    pdq.poll();
                    sdq.poll();
                    count++;


                }
                if(count > 0){
                    answerList.add(count);
                }



            }
            System.out.println(answerList);
            answer = answerList.stream()
                    .mapToInt(i -> i)
                    .toArray();

            return answer;
        }
    }
}
