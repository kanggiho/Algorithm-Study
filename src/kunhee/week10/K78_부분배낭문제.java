package kunhee.week10;

/*
문제 설명:
무게와 가치가 있는 짐 items와 배낭 weight_limit이 주어질 때, 부분 배낭 문제를 푸는 solution() 함수를 작성해주세요.

제약조건:
- weight_limit은 1 이상 10,000 이하의 자연수입니다.
- items의 길이는 1 이상 1,000 이하입니다.
*/

import java.util.Arrays;

public class K78_부분배낭문제 {

    public static double solution(int[][] items, int weight_limit) {

        double answer = 0;

        double[][] value = new double[items.length][2];

        for (int i = 0; i < items.length; i++) {
            value[i][0] = items[i][0];
            value[i][1] = (double) items[i][1] / items[i][0];
        }

        Arrays.sort(value, (a, b) -> Double.compare(b[1], a[1]));

        for (int i = 0; i < value.length; i++) {
            if (value[i][0] <= weight_limit) {
                answer += value[i][1] * value[i][0];
                weight_limit -= (int) value[i][0];
            } else {
                answer += value[i][1] * weight_limit;
                break;
            }
        }

        return answer;
    }

    // 테스트
    public static void main(String[] args) {
        int[][] items1 = {{10, 19}, {7, 10}, {6, 10}};
        int weight_limit1 = 15;
        System.out.println(solution(items1, weight_limit1));

        int[][] items2 = {{10, 60}, {20, 100}, {30, 120}};
        int weight_limit2 = 50;
        System.out.println(solution(items2, weight_limit2));
    }
}