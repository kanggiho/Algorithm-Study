package heonwoo.week08;

public class H59_배열회전하기 {
    private static int[][] rotate90(int[][] arr) {
        // 배열의 크기 저장
        int n = arr.length;

        // 배열의 크기와 동일한 2차원 배열 생성(초깃값은 0)
        int[][] rotatedArr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotatedArr[j][n - i - 1] = arr[i][j];
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
}
