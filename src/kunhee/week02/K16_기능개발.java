package kunhee.week02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class K16_기능개발 {

    public static int[] solution(int[] progresses, int[] speeds) {

        List<Integer> result = new ArrayList<>();
        Queue<Integer> days = new LinkedList<>();

        // 각 기능 걸리는 시간 계산해서 큐에 넣기
        for (int i = 0; i < progresses.length; i++) {
            int remaining = 100 - progresses[i];
            int day = (int) Math.ceil((double) remaining / speeds[i]);  // 올림
            days.add(day);
        }

        // for (int i = 0; i < progresses.length; i++) {  --> poll()이 한 번에 여러 개 호출될 수 있어서 오류
        //    // ...
        //}
        while (!days.isEmpty()) {
            int current = days.poll(); // 첫 번째 기능 완료일
            int count = 1;

            // 다음 기능들이 current 날짜에 같이 배포될 수 있는지 확인
            while (!days.isEmpty() && days.peek() <= current) {
                days.poll();
                count++;
            }

            result.add(count);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

}
