package jino.week07;

public class J_마법의엘리베이터 {
    class Solution {
        private int answer = 0;
        public int solution(int storey) {
            String sStorey = storey + "";
            // System.out.println((int)Math.pow(10,sStorey.length()-1));1000
            //System.out.println(storey / ((int)Math.pow(10,sStorey.length()-1)));

            while(sStorey.length() > 1){
                int sexy = (int)Math.pow(10,sStorey.length()-1);
                if((int)(sStorey.charAt(0) - '0') > 5){
                    answer += 10 - (int)(sStorey.charAt(0) - '0') +1;
                    storey = storey % sexy;
                    sStorey = storey + "";
                }
                else{
                    answer = answer + (storey / sexy );
                    storey = storey % sexy;
                    System.out.println(answer);
                    sStorey = storey + "";
                }

            }
            if(storey > 5){
                answer += 10 - storey +1;
                return answer;
            }
            answer += storey;
            return answer;


        }
    }
}
