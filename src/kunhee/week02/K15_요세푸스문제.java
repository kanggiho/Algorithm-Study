package kunhee.week02;

import java.util.LinkedList;
import java.util.Queue;

public class K15_요세푸스문제 {

    public static int solution(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();

        // 1 ~ n 사람을 큐에 넣음
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        // 사람이 1명 남을 때까지 반복
        while (queue.size() > 1) {
            // K-1명은 맨 뒤로 보내기
            for (int i = 1; i < k; i++) {
                queue.add(queue.poll());
            }

            // K번째 사람 제거
            queue.poll();
        }

        // 마지막 남은 사람
        return queue.peek();
    }

}
