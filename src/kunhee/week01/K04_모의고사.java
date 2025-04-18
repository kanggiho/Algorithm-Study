package kunhee.week01;

import java.util.ArrayList;
import java.util.List;

public class K04_모의고사 {

    public static int[] solution(int[] answers) {
        // 패턴 정의
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] scores = new int[3]; // 각 수포자의 정답 개수 저장

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == p1[i % p1.length]) scores[0]++;
            if (answers[i] == p2[i % p2.length]) scores[1]++;
            if (answers[i] == p3[i % p3.length]) scores[2]++;
        }

        // 최고 점수 계산
        int max = Math.max(scores[0], Math.max(scores[1], scores[2]));

        // 최고 점수를 받은 수포자 번호를 리스트에 추가
        // int[]는 길이가 고정된 배열 / List는 크기를 동적으로 조절
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (scores[i] == max) {
                result.add(i + 1); // 수포자 번호는 1번부터 시작
            }
        }

        // List → int[] 변환
        return result.stream().mapToInt(i -> i).toArray();
    }

}
