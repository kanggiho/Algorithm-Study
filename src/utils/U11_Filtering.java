package utils;

import java.util.Arrays;

public class U11_Filtering {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        // 스트림 방식으로 짝수 필터링
        int[] evens = Arrays.stream(arr)
                .filter(n -> n % 2 == 0)
                .toArray();

        // 조건 만족하는 요소 개수 반환
        long count = Arrays.stream(arr)
                .filter(n -> n > 2)
                .count();

    }
}
