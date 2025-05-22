package utils;

public class U01_String {
    public static void main(String[] args) {
        String str = "apple";

        // 길이 반환
        str.length();

        // 빈 문자열 체크
        str.isEmpty();

        // 문자 찾기
        str.charAt(0);            // 'a' -> 문자 반환
        str.indexOf("a");         // 0 -> 인덱스 반환
        str.lastIndexOf("p");     // 2 -> 마지막으로 문자가 속한 인덱스 반환

        // 문자열 자르기
        str.substring(1, 3);      // "pp" -> 인덱스 1 이상 3 미만 위치의 문자열 반환
        str.substring(3);         // "le" -> 인덱스 3 미만 위치의 문자열 반환

        // 문자열 치환 (바꾸기)
        str.replace('p', 'e');           // "aeele" -> 모든 기존 문자를 [바꿀 문자]로 치환
        str.replaceAll(".", "/");        // "/////" -> 정규식에 맞춰 문자 치환 ("."은 모든 문자를 의미)
        str.replaceFirst("p", "e");      // "aeple" -> 여러 문자 중 첫 번째만 치환

        // 문자열 동일 여부 판단
        str.equals("apple");  // Java string은 참조값 비교가 아닌 equals()로 내용 비교

        // 문자열 비교
        /**
         * str과 "apple"이 같으면 0
         * str이 사전순으로 앞서면 -1
         * str이 사전순으로 뒤면 1
         * 마지막 문자가 다르면, 마지막 문자의 사전순 차이 반환
         */
        str.compareTo("applf");  // 예: -1

        // 문자열 포함 여부 판단
        str.contains("app"); // true

        // 문자열 분리
        str.split(" ");       // 공백으로 분리된 문자열 str을 String[] 배열로 반환
        str.split("");        // 한 글자씩 쪼개어 String[] 배열로 반환

        // 문자열 앞뒤 공백 제거
        str.trim();           // 문자열 양끝 공백만 제거. 중간 공백은 제거하지 않음.

        // 공백 제거
        str.replaceAll("\\s", "");      // 공백 문자(띄어쓰기, 탭, 줄바꿈 등)를 모두 제거
        str.replace(" ", "");          // 띄어쓰기만 제거

        // 문자열 <-> 숫자 변환
        Integer.parseInt("100");   // 문자열 "100" → 숫자 100
        Integer.toString(100);     // 숫자 100 → 문자열 "100"
    }
}
