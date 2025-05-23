package kunhee.week04;

public class 유연근무제 {

    class Solution {
        public int solution(int[] schedules, int[][] timelogs, int startday) {
            int n = schedules.length;
            int answer = n;
            // 1이면 j = 5,6 생략
            // 2이면 j = 4,5 생략
            // 3이면 j = 3,4 생략
            // 4이면 j = 2,3 생략
            // 5이면 j = 1,2 생략
            // 6이면 j = 0,1 생략
            // 7이면 j = 6,0 생략
            int day1 = 7 - startday;
            int day2 = 6 - startday;
            if (day2 < 0) {
                day2 = 6;
            }

            // 분으로 변환 + 10분 더하기
            for(int i = 0 ;i<schedules.length; i++){
                schedules[i]=(schedules[i]/100)*60+(schedules[i]%100)+10;
            }

            // 분으로 변환
            for(int i = 0 ;i<timelogs.length;i++){
                for(int j = 0 ; j<timelogs[i].length;j++){
                    timelogs[i][j]=(timelogs[i][j]/100)*60+(timelogs[i][j]%100);
                }
            }

            for (int i=0; i < n; i++) {
                for (int j = 0; j < 7; j++) {

                    if (j == day1 || j == day2) continue;

                    // 시간을 분으로 다 바꿔주지 않아서 오류
                    if (schedules[i] + 10 < timelogs[i][j]) {
                        answer--;
                        break;
                    }
                }
            }

            return answer;
        }
    }
}
