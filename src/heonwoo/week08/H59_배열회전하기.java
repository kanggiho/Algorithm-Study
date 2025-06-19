package heonwoo.week08;

import java.util.Arrays;

public class H59_배열회전하기 {

    private static int[][] rotate90(int[][] arr) {
        int n = arr.length;
        int[][] rotatedArr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotatedArr[i][j] = arr[n - 1 - j][i];
            }
        }

        return rotatedArr;
    }

    private static int[][] solution(int[][] arr, int n) {
        for (int i = 0; i < n; i++) {
            arr = rotate90(arr);
        }
        return arr;
    }

    // ✅ main 함수 예시
    public static void main(String[] args) {
        int[][] original = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int rotateCount = 1; // 90도 회전 횟수 (1회 → 90도)

        int[][] result = solution(original, rotateCount);

        System.out.println("회전 결과:");
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}