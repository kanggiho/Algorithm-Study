package utils;

public class U02_StringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        // 문자열 추가
        sb.append("apple");             // "apple"

        // 특정 인덱스에 문자열 삽입
        sb.insert(2, "oo");             // "apoople"

        // 문자열 삭제
        sb.delete(0, 2);                // "oople"

        // 특정 인덱스의 문자 삭제
        sb.deleteCharAt(2);            // "oole"

        // 특정 인덱스의 문자를 변경
        sb.setCharAt(1, 'p');          // "ople"

        // 문자열 뒤집기
        sb.reverse();                  // "elpo"

        // 문자열 절대길이 줄이기
        sb.setLength(2);               // "el"

        // 문자열 절대길이 늘이기 (뒤가 공백으로 채워짐)
        sb.setLength(4);               // "el  "

    }
}
