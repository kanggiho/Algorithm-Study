package kunhee.week08;

// https://school.programmers.co.kr/learn/courses/30/lessons/70129

import java.util.Arrays;

public class k62_이진변환반복하기 {

    public static int[] solution(String s) {

        int[] result = new int[2];

        while (!s.equals("1")) {

            // 0 제거 후 길이 구하기
            int beforeLength = s.length();
            String deleted = s.replaceAll("0", "");
            int afterLength = deleted.length();

            // 제거한 0의 개수 계산
            result[1] = result[1] + beforeLength - afterLength;

            // 2진법으로 표현한 문자열로 바꾸기
            StringBuilder newString = new StringBuilder();
            while (0 < afterLength) { // 1 <= afterLength
                newString.append(afterLength % 2);
                afterLength = afterLength / 2;
            }
            s = newString.reverse().toString();

            // 변환 횟수 계산
            result[0]++;
        }

        return result;
    }


    // 테스트
    public static void main(String[] args) {
        String s1 = "110010101001";
        String s2 = "01110";
        String s3 = "1111111";

        System.out.println(Arrays.toString(solution(s1)));
        System.out.println(Arrays.toString(solution(s2)));
        System.out.println(Arrays.toString(solution(s3)));
    }
}