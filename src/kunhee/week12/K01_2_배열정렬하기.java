package kunhee.week12;

/*
문제 설명:
정수 배열을 정렬해서 반환하는 solution() 함수를 완성하세요.

제약조건:
- 정수 배열의 길이는 2이상 10^5 이하입니다.
- 정수 배열의 각 데이터 값은 -100,000 이상 100,000 이하입니다.
*/

import java.util.Arrays;

public class K01_2_배열정렬하기 {

    public static int[] solution(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }

}
