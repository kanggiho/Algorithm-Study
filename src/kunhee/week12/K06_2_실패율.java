package kunhee.week12;

// https://school.programmers.co.kr/learn/courses/30/lessons/42889

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class K06_2_실패율 {

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        // 스테이지별 인원
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int stage : stages) {
            countMap.put(stage, countMap.getOrDefault(stage, 0) + 1);
        }

        // 스테이지별 실패율
        double[] rate = new double[N];

        // 실패율 계산
        int people = stages.length;
        for (int i = 1; i < N + 1; i++) {
            rate[i - 1] =  people == 0 ? 0 : (double) countMap.getOrDefault(i, 0) / people;
            people -= countMap.getOrDefault(i, 0);
        }

        // 실패율 기준으로 정렬
        for (int i = 0; i < N; i++) {
            double max = 0;
            int index = -1;
            for (int j = N - 1; j >= 0; j--) {
                if (max <= rate[j]) {
                    max = rate[j];
                    answer[i] = j + 1;
                    index = j;
                }
            }
            rate[index] = -1;
        }

        return answer;
    }

    public static void main(String[] args) {
        // 테스트 케이스 1
        int N1 = 5;
        int[] stages1 = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] result1 = solution(N1, stages1);
        System.out.println(Arrays.toString(result1));  // 예상 출력: [3, 4, 2, 1, 5]

        // 테스트 케이스 2
        int N2 = 4;
        int[] stages2 = {4, 4, 4, 4, 4};
        int[] result2 = solution(N2, stages2);
        System.out.println(Arrays.toString(result2));  // 예상 출력: [4, 1, 2, 3]
    }

}
