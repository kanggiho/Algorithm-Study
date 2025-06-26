package kunhee.week10;

// https://school.programmers.co.kr/learn/courses/30/lessons/12982

import java.util.Arrays;

public class k79_예산 {

    public static int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);

        for (int i = 0; i < d.length; i++) {
            if (d[i] <= budget) {
                budget -= d[i];
                answer++;
            }
        }

        return answer;
    }

    // 테스트
    public static void main(String[] args) {
        int[] d1 = {1,3,2,5,4};
        int budget1 = 9;
        System.out.println(solution(d1, budget1));

        int[] d2 = {2,2,3,3};
        int budget2 = 10;
        System.out.println(solution(d2, budget2));
    }
}