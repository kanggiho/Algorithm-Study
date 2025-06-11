package giho.week07;

public class G60_두행렬곱전치 {

    public static final int N = 3;

    public static void main(String[] args) {
        int[][] arr1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] arr2 = {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        };

        int[][] ansArr = multiplyTranspose(arr1, arr2);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(ansArr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int[][] multiplyTranspose(int[][] arr1, int[][] arr2){
        int[][] multiplyArr = new int[N][N];
        int[][] transposeArr = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    multiplyArr[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                transposeArr[i][j] = multiplyArr[j][i];
            }
        }
        return transposeArr;
    }
}