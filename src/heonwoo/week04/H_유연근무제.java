package heonwoo.week04;

public class H_유연근무제 {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        for(int i = 0; i < schedules.length; i++) {
            int time = (schedules[i]/100) + ((schedules[i]%100) + 10)/60;
            if (time == schedules[i]/100){
                schedules[i] = schedules[i] + 10;
            } else {
                schedules[i] = time*100 + ((schedules[i]%100)%10);
            }
        }

        //테스트 케이스 수만큼
        for(int i = 0; i < timelogs.length; i++) {
            boolean check = true;
            for(int j = 0; j < timelogs[i].length; j++) {
                int day = (startday + j -1) % 7;

                if (day == 5 || day == 6) {
                    continue;
                }

                if (schedules[i] < timelogs[i][j]){
                    check = false;
                    break;
                }
            }
            if (check) {
                answer++;
            }
        }


        return answer;
    }
}
