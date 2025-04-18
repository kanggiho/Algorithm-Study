package heonwoo.week01;

import java.util.Arrays;
import java.util.Collections;

public class H02_배열제어하기 {
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 1, 3, 4};
        int[] answer = solution(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(answer));
    }

    private static int[] solution(int[] arr) {
        Integer[] result = Arrays.stream(arr).boxed().distinct().
                toArray(Integer[]::new);
        Arrays.sort(result, Collections.reverseOrder());
        return Arrays.stream(result).mapToInt(x -> x).toArray();
    }
}
