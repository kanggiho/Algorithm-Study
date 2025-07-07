package kunhee.week12;

// https://school.programmers.co.kr/learn/courses/30/lessons/12985

public class K26_2_예상대진표 {

    public static int solution(int n, int a, int b) {
        int answer = 0;

        while (a != b) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        // 테스트 케이스 1
        int n1 = 8;
        int a1 = 4;
        int b1 = 7;
        int result1 = solution(n1, a1, b1);
        System.out.println(result1);  // 예상 출력: 3
    }
}
