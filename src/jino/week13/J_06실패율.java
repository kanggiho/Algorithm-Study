package jino.week13;

import java.util.Arrays;

public class J_06실패율 {
    
    class Solution {
        private static int[] answer;
        private static int[] Stages;
        private static double[] failRate;

        public int[] solution(int N, int[] stages) {
            int people  = stages.length;
            Stages = new int[N + 2];
            failRate = new double[N];
            answer = new int[N];

            for(int i = 0 ; i < stages.length ; i++){
                Stages[stages[i]]++;
            }
            for(int i = 0 ; i < failRate.length ; i++){
                if(Stages[i + 1] == 0 || people == 0){
                    failRate[i] = 0;
                }
                else{
                    failRate[i] = (double)Stages[i + 1] / people;
                    people -= Stages[i + 1];
                }
            }
            for(int i = 0 ; i < failRate.length ; i++){
                System.out.print(failRate[i] + " ");
            }
            Fail[] fail = new Fail[N];
            for(int i = 0 ; i < fail.length ; i++){
                fail[i] = new Fail(i + 1, failRate[i]);
            }
            Arrays.sort(fail, (o1, o2) ->{
                return Double.compare (o2.rate , o1.rate);
            });
            for(int i = 0; i < fail.length ; i++){
                answer[i] = fail[i].stage;
            }

            return answer;
        }
        private static class Fail{
            int stage;
            double rate;
            public Fail(int stage, double rate){
                this.stage = stage;
                this.rate = rate;
            }
        }
    }
}
