package kunhee.week11;

// https://school.programmers.co.kr/learn/courses/30/lessons/150365

public class K83_미로탈출명령어 {

    public static String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        return answer;
    }


    // 테스트
    public static void main(String[] args) {

        // 테스트 케이스 1
        int n1 = 3, m1 = 4, x1 = 2, y1 = 3, r1 = 3, c1 = 1, k1 = 5;
        String result1 = solution(n1, m1, x1, y1, r1, c1, k1);
        System.out.println(result1);  // 예상 출력: dllrl

        // 테스트 케이스 2
        int n2 = 2, m2 = 2, x2 = 1, y2 = 1, r2 = 2, c2 = 2, k2 = 2;
        String result2 = solution(n2, m2, x2, y2, r2, c2, k2);
        System.out.println(result2);  // 예상 출력: dr

        // 테스트 케이스 3
        int n3 = 3, m3 = 3, x3 = 1, y3 = 2, r3 = 3, c3 = 3, k3 = 4;
        String result3 = solution(n3, m3, x3, y3, r3, c3, k3);
        System.out.println(result3);  // 예상 출력: impossible
    }
}