package kunhee.week07;

import java.util.Arrays;

public class k54_K번째수 {

    public static int[] solution(int[] array, int[][] commands) {

        int n = commands.length;

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int startIdx = commands[i][0] - 1;
            int endIdx = commands[i][1] - 1;
            int answerIdx = commands[i][2] - 1;

            int[] newArr = new int[endIdx - startIdx + 1];
            for (int j = startIdx; j <= endIdx; j++) {
                newArr[j - startIdx] = array[j];
            }
            // int[] newArr = Arrays.copyOfRange(array, startIdx, endIdx + 1);

            Arrays.sort(newArr);

            result[i] = newArr[answerIdx];
        }

        return result;
    }

    // 테스트
    public static void main(String[] args) {
        int[] a = {1, 5, 2, 6, 3, 7, 4};
        int[][] b = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println(Arrays.toString(solution(a, b)));
    }
}
