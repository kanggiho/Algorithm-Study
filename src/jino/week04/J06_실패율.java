package jino.week04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class J06_실패율 {

    class Solution {
        private static int[] stage; // 스테이지 수
        private static int people;//현재 남은 사람수
        private static int[] stageInPeople;//스테이지 사람수
        private static double[] failRate;// 실패율
        private static List<Integer> answerList;


        public int[] solution(int N, int[] stages) {
            //초기화
            int[] answer = new int[N];
            stage = new int [N+2];
            people = stages.length;
            stageInPeople = new int[N+2];
            failRate = new double[N+1];
            answerList = new ArrayList<>();

            for(int i = 1 ; i <= N ;i++){
                answerList.add(i);
            }

            // 스테이지 사람수 저장
            for(int i = 0 ; i < stages.length ;i++){
                stageInPeople[stages[i]]++;
            }

            //  for(int i = 0 ; i < stageInPeople.length ;i++){
            //     System.out.println(stageInPeople[i]);
            // }


            for (int i = 1; i < failRate.length ;i++ ){
                if(people != 0 ){
                    failRate[i] =(double)stageInPeople[i] / people;
                    System.out.println(i +" >>" + failRate[i]);
                }else{
                    failRate[i] = 0;
                }


                people -= stageInPeople[i];
            }

            Collections.sort(answerList,(a, b)->{
                if(failRate[a] == failRate[b]){
                    return a - b;
                }
                return Double.compare(failRate[b] , failRate[a]);
            });


            answer = answerList.stream()
                    .mapToInt(i -> i)
                    .toArray();




            return answer;
        }
    }
}
