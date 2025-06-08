package kunhee.week07;

import java.util.Arrays;

public class k55_가장큰수 {

    public static String solution(int[] numbers) {

        String[] strArr = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            strArr[i] = Integer.toString(numbers[i]); // 또는 String.valueOf(numbers[i]);
        }

        Arrays.sort(strArr);

        for (int i = 1; i < strArr.length; i++) {
            if ((strArr[i - 1] + strArr[i]).compareTo((strArr[i] + strArr[i - 1])) < 0) {
                strArr[i] = strArr[i] + strArr[i - 1];
            } else {
                strArr[i] = strArr[i - 1] + strArr[i];
            }
        }


        return strArr[strArr.length - 1];
    }

    // 테스트
    public static void main(String[] args) {
        int[] a = {6, 10, 2};
        int[] b = {3, 30, 34, 5, 9};
        System.out.println(solution(a));
        System.out.println(solution(b));
    }
}

/*

자바에서 String.compareTo(anotherString)의 동작 기준:

비교 조건	                결과
왼쪽부터 한 글자씩 비교	    다르면 그 순간 결정 ("300" < "90")
모두 같고 길이도 같음	        0 (같다)
모두 같고 한 쪽이 더 길다	    긴 쪽이 더 크다 ("9" < "91")

 */

/*

| 구분        |      `String.valueOf()`          | `Integer.toString()`    |
| -------    | ----------------------------     |  ----------------------- |
| null 처리  | `"null"` 문자열로 반환              | NullPointerException 발생 |
| 유연성     | 모든 타입 가능 (Object 포함)         | 오직 int만 가능            |
| 성능       | 내부에서 `Integer.toString()` 호출  | 직접 변환                  |
| 사용 권장   | 더 범용적인 코드**가 필요할 때        | 정확히 int만 처리**할 때    |


 */