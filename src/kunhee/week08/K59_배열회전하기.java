package kunhee.week08;

/*
문제 설명:
2차원 배열 arr을 시계 방향으로 90도 * n번 회전하는 solution() 함수를 작성하세요.

제약조건:
- 회전 횟수 n은 자연수이며 1~4입니다.
- 2차원 배열의 행과 열의 크기는 같고, 행의 크기는 10을 넘지 않습니다.
*/

import java.util.Arrays;

public class K59_배열회전하기 {

    public static int[][] solution(int[][] arr, int n) {

        int length = arr.length;

        for (int i = 0; i < n; i++) {
            int[][] rotated = new int[length][length];

            for (int y = 0; y < length; y++) {
                for (int x = 0; x < length; x++) {
                    rotated[y][length - 1 - x] = arr[x][y];
                }
            }
            arr = rotated;
        }

        return arr;
    }

    // 테스트
    public static void main(String[] args) {
        int[][] arr1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int n1 = 1;
        int n2 = 2;

        System.out.println(Arrays.deepToString(solution(arr1, n1)));
        System.out.println(Arrays.deepToString(solution(arr1, n2)));
    }
}