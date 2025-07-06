package kunhee.week07;

import java.util.Arrays;

public class K51_정렬이완료된두배열합치기 {

    public static int[] solution(int[] arr1, int[] arr2) {

        int a = arr1.length;
        int b = arr2.length;

        int[] result = new int[a + b];

        int p1 = 0;
        int p2 = 0;

        while (p1 < a && p2 < b) {
            if (arr1[p1] < arr2[p2]) {
                result[p1 + p2] = arr1[p1];
                p1++;
            } else {
                result[p1 + p2] = arr2[p2];
                p2++;
            }
        }

        while (p1 < a) {
            result[p1 + p2] = arr1[p1];
            p1++;
        }
        while (p2 < b) {
            result[p2 + p1] = arr2[p2];
            p2++;
        }


        return result;
    }

    // 테스트
    public static void main(String[] args) {
        int[] a = {1, 3, 5};
        int[] b = {2, 4, 6};
        System.out.println(Arrays.toString(solution(a, b)));
        int[] c = {1, 2, 3};
        int[] d = {4, 5, 6};
        System.out.println(Arrays.toString(solution(c, d)));
        int[] e = {1, 2, 4};
        int[] f = {3, 5, 6, 7, 8};
        System.out.println(Arrays.toString(solution(e, f)));
    }
}
