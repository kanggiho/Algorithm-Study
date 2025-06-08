package heonwoo.week07;

import java.util.Arrays;

public class H54_K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[array.length];

        for (int c = 0; c < commands.length; c++) {
            int i = commands[c][0];
            int j = commands[c][1];
            int k = commands[c][2];

            // i번째 부터 j번째까지 자르기
            int[] slicedArr = Arrays.copyOfRange(array, i - 1, j);
            // 자른 배열을 정렬하기
            Arrays.sort(slicedArr);
            // k번째 원소 구하기
            answer[c] = slicedArr[k - 1];
        }
        return answer;
    }
}
