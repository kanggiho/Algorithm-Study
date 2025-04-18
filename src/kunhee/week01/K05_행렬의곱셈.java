package kunhee.week01;

public class K05_행렬의곱셈 {

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int row = arr1.length; // arr1의 행
        int col = arr2[0].length; // arr2의 열
        int shared = arr1[0].length; // arr1의 열 == arr2의 행

        int[][] result = new int[row][col];

        // 행렬 곱셈
        for (int i = 0; i < row; i++) { // arr1의 행
            for (int j = 0; j < col; j++) { // arr2의 열
                for (int k = 0; k < shared; k++) { // 공통 차원
                    result[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return result;
    }

}
