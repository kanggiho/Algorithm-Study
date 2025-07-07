package kunhee.week09;

// https://school.programmers.co.kr/learn/courses/30/lessons/12983

public class K76_단어퍼즐 {

    public static int solution(String[] strs, String t) {
        int answer = 0;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }

    // 테스트
    public static void main(String[] args) {
        String[] strs1 = {"ba", "na", "n", "a"};
        String t1 = "banana";
        System.out.println(solution(strs1, t1));

        String[] strs2 = {"app", "ap", "p", "l", "e", "ple", "pp"};
        String t2 = "apple";
        System.out.println(solution(strs2, t2));
    }
}