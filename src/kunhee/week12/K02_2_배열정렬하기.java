package kunhee.week12;

/*
문제 설명:
정수 배열을 하나 받습니다.
배열의 중복값을 제거하고 배열 데이터를 내림차순으로 정렬해서 반환하는 solution() 함수를 구현하세요.

제약조건:
- 배열 길이는 2 이상 1,000 이하입니다.
- 각 배열의 데이터 값은 -100,000 이상 100,000 이하입니다.
*/

import java.util.*;

public class K02_2_배열정렬하기 {

    public static int[] solution(int[] arr) {
        return Arrays.stream(arr)
                .boxed() // int -> Integer (객체로 변환)
                .distinct() // 중복 제거
                .sorted(Comparator.reverseOrder()) // 내림차순 정렬
                .mapToInt(Integer::intValue) // 다시 int로 변환
                .toArray(); // 배열로 반환
    }

}
