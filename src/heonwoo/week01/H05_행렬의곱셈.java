package heonwoo.week01;

import java.util.Arrays;

public class H05_행렬의곱셈 {
    public static void main(String[] args) {
        int[][] arr1 = {{1,4}, {3,2}, {4,1}};
        int[][] arr2 = {{3,3}, {3,3}};
        int[][] answer = solution(arr1, arr2);
        System.out.println(Arrays.deepToString(answer));
    }

    private static int[][] solution(int[][] arr1, int[][] arr2) {
        // 행렬 곱의 결과는 arr1의 행 수 x arr2의 열 수 크기를 가짐
        int[][] matrix = new int[arr1.length][arr2[0].length];

        // arr1의 각 행에 대해
        for (int i = 0; i < arr1.length; i++) {
            // arr2의 각 열에 대해
            for(int j = 0; j < arr2[0].length; j++) {
                int temp = 0;

                // arr1의 열 수(= arr2의 행 수)만큼 반복하여 곱셈 후 덧셈 (행렬의 곱셈조건은 arr1의 열 수와 arr2의 행 수가 같아야함)
                for (int k = 0; k < arr2.length; k++) {
                    // arr1의 i행 k열 * arr2의 k행 j열을 누적
                    temp += arr1[i][k] * arr2[k][j];
                }

                // 계산된 값을 결과 행렬의 i행 j열에 저장
                matrix[i][j] = temp;
            }
        }
        return matrix;
    }
}
