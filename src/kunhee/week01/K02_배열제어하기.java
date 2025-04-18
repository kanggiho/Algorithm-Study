package kunhee.week01;

import java.util.Arrays;
import java.util.Comparator;

public class K02_배열제어하기 {

    public static int[] solution(int[] arr) {
        return Arrays.stream(arr)
                .boxed() // int -> Integer (객체로 변환)
                .distinct() // 중복 제거
                .sorted(Comparator.reverseOrder()) // 내림차순 정렬
                .mapToInt(Integer::intValue) // 다시 int로 변환
                .toArray(); // 배열로 반환
    }

}
