package kunhee.week07;

public class k50_계수정렬구현하기 {

    public static String solution(String s) {
        int[] count = new int[26]; // 알파벳 소문자 a~z에 해당하는 개수를 담을 배열

        // 각 문자 카운트
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // 정렬된 문자열 만들기
        StringBuilder sorted = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < count[i]; j++) {
                sorted.append((char) (i + 'a'));
            }
        }

        return sorted.toString();
    }

    // 테스트
    public static void main(String[] args) {
        String input = "cbacdcbc";
        System.out.println(solution(input)); // 출력: abccbccd
    }
}
