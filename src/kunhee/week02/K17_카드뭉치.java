package kunhee.week02;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class K17_카드뭉치 {

    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> q1 = new LinkedList<>(Arrays.asList(cards1));
        Queue<String> q2 = new LinkedList<>(Arrays.asList(cards2));

        for (String word : goal) {
            // q1의 맨 앞과 일치하면 꺼내기
            if (!q1.isEmpty() && q1.peek().equals(word)) {
                q1.poll();
            }
            // q2의 맨 앞과 일치하면 꺼내기
            else if (!q2.isEmpty() && q2.peek().equals(word)) {
                q2.poll();
            }
            // 둘 다 아니면 실패
            else {
                return "No";
            }
        }

        return "Yes";
    }

}
