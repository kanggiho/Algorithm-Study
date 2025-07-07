package kunhee.week09;

// https://school.programmers.co.kr/learn/courses/30/lessons/12945

public class K70_피보나치수 {

    public static int solution(int n) {

        if (n < 2) return 0;

        int[] fibo = new int[n + 1];
        fibo[0] = 0;
        fibo[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 1234567;
        }

        // return fibo[n] % 1234567; --> 여기서 나눠주지 말고 매 연산마다 모듈러연산 필요
        return fibo[n];
    }

    // 테스트
    public static void main(String[] args) {
        int n1 = 3;
        System.out.println(solution(n1));

        int n2 = 5;
        System.out.println(solution(n2));

        int n3 = 46;
        System.out.println(solution(n3));

        int n4 = 47; // 모듈러연산 필요
        System.out.println(solution(n4));
    }
}