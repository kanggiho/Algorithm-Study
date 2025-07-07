package kunhee.week08;

// https://school.programmers.co.kr/learn/courses/30/lessons/42842

import java.util.Arrays;

public class K64_카펫 {

    public static int[] solution(int brown, int yellow) {

        int[] answer = new int[2];

        // 2 * (x + y) - 4 == brown
        // (x - 2) * (y - 2) == yellow
        // x * y == brown + yellow
        // x >= y

        int total = brown + yellow;

        int width = total / 3;

        for (int height = 3; height <= width; height++) {

            width = total / height;

            if ((width - 2) * (height - 2) == yellow) {
                answer[0] = width;
                answer[1] = height;
                break;
            }

        }

        return answer;
    }

    // 테스트
    public static void main(String[] args) {
        int brown1 = 10;
        int yellow1 = 2;

        int brown2 = 8;
        int yellow2 = 1;

        int brown3 = 24;
        int yellow3 = 24;

        System.out.println(Arrays.toString(solution(brown1, yellow1)));
        System.out.println(Arrays.toString(solution(brown2, yellow2)));
        System.out.println(Arrays.toString(solution(brown3, yellow3)));
    }
}