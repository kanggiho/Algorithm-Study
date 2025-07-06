package kunhee.week09;

// https://school.programmers.co.kr/learn/courses/30/lessons/12900

public class K71_2Xn타일링 {

    public static int solution(int n) {

        if (n == 1) return 1;
        if (n == 2) return 2;

        // 피보나치 수열을 1, 2부터 시작하는 버전
        int a = 1, b = 2;
        int temp = 0;

        for (int i = 3; i <= n; i++) {
            temp = (a + b) % 1000000007;
            a = b;
            b = temp;
        }

        return b;
    }

    // 테스트
    public static void main(String[] args) {
        int n1 = 4;
        System.out.println(solution(n1));

        int n2 = 5;
        System.out.println(solution(n2));

        int n3 = 8;
        System.out.println(solution(n3));
    }
}