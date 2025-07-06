package kunhee.week08;

/*
문제 설명:
matrix1과 matrix2는 정수값으로 이루어진 3x3 행렬입니다.
이 두 행렬을 곱한 결과의 전치 행렬을 반환하는 solution(0 함수를 구현해주세요.

제약조건:
- matrix1, matrix2는 각각 3X3 크기의 정수 행렬입니다.
- 2차원 배열의 행과 열의 크기는 같고, 행의 크기는 10을 넘지 않습니다.
*/


import java.util.Arrays;

public class K60_두행렬을곱한후전치행렬만들기 {

    public static int[][] multiply(int[][] matrix1, int[][] matrix2) {

        int m = matrix1.length;
        int n = matrix2[0].length;
        int l = matrix1[0].length;
        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < l; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }
    public static int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }

    public static int[][] solution(int[][] matrix1, int[][] matrix2) {

        int[][] multiplied = multiply(matrix1, matrix2);
        int[][] transposed = transpose(multiplied);

        return transposed;
    }

    // 테스트
    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};

        int[][] matrix3 = {{2, 4, 6}, {1, 3, 5}, {7, 8, 9}};
        int[][] matrix4 = {{9, 1, 2}, {4, 5, 6}, {7, 3, 8}};

        System.out.println(Arrays.deepToString(solution(matrix1, matrix2)));
        System.out.println(Arrays.deepToString(solution(matrix3, matrix4)));
    }
}