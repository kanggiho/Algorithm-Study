package giho.week07;

public class G59_배열회전하기 {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int n = 4;

        for (int i = 0; i < n; i++) {
            arr = rotate(arr);
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] rotate(int[][] arr) {
        int[][] newArr = new int[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                newArr[j][arr.length - 1 - i] = arr[i][j];
            }
        }

        return newArr;

    }
}
