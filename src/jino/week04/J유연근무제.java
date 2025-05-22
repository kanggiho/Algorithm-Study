package jino.week04;

import java.util.Arrays;

public class J유연근무제 {

    class Solution {
        private int cutTime;
        private int answer;
        private int nowDay;
        public int solution(int[] schedules, int[][] timelogs, int startday) {
            //초기화
            answer = 0;
            Arrays.sort(schedules);
            cutTime = schedules[schedules.length - 1] + 10;
            System.out.println(cutTime);
            nowDay = startday;



            //사간 문제는 분으로 변경
            for(int i = 0 ; i < timelogs.length ; i++){
                boolean flag = true;
                nowDay = startday;
                for(int j = 0 ; j < timelogs[i].length ; j++){
                    if(nowDay % 7 == 0 || nowDay % 7 == 6) continue;
                    else if(timelogs[i][j] > cutTime){
                        flag = false;
                        break;
                    }
                    nowDay++;
                }//내부 for

                if(flag){
                    answer++;
                }

            }//외 부 for



            return answer;
        }
    }
}
