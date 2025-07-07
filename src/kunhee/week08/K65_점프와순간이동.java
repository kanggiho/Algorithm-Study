package kunhee.week08;

// https://school.programmers.co.kr/learn/courses/30/lessons/42842

public class K65_점프와순간이동 {

    public static int solution(int n) {

        return Integer.toBinaryString(n).replace("0", "").length();
    }

    // 테스트
    public static void main(String[] args) {
        int n1 = 5;
        int n2 = 6;
        int n3 = 5000;
        System.out.println(solution(n1));
        System.out.println(solution(n2));
        System.out.println(solution(n3));
    }
}