package kunhee.week10;

// https://school.programmers.co.kr/learn/courses/30/lessons/42885

import java.util.Arrays;

public class K80_구명보트 {

    public static int solution(int[] people, int limit) {
        int answer = people.length;

        Arrays.sort(people);

        int heavy = people.length - 1;
        int light = 0;

        while (light < heavy) {
            if (people[heavy] + people[light] <= limit) {
                heavy--;
                light++;
                answer--;
            } else {
                heavy--;
            }
        }

        return answer;
    }

    // 테스트
    public static void main(String[] args) {
        int[] people1 = {70, 50, 80, 50};
        int limit = 100;
        System.out.println(solution(people1, limit));

        int[] people2 = {70, 80, 50};
        System.out.println(solution(people2, limit));

        int[] people3 = {30, 70, 50, 40};
        System.out.println(solution(people3, limit));
    }
}