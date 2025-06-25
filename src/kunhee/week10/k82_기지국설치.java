package kunhee.week10;

// https://school.programmers.co.kr/learn/courses/1`30/lessons/12979

public class k82_기지국설치 {

    public static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int len = stations.length;
        int cover = 2 * w + 1;

        // 첫 구간
        int left = stations[0] - w - 1;

        if (left > 0) {
            answer += (left + cover - 1) / cover;
        }

        // 중간 구간
        if (len > 1) {
            for (int i = 1; i < len; i++) {
                int gap = (stations[i] - stations[i - 1]) - cover;

                if (gap > 0) {
                    answer += (gap + cover - 1) / cover;
                }
            }
        }

        // 마지막 구간
        int right = n - w - stations[len - 1];

        if (right > 0) {
            answer += (right + cover - 1) / cover;
        }

        return answer;
    }

    /*
    ----- 몫 올림 공식 == 아래 조건문 -----

    answer += (gap + cover - 1) / cover;

    if (gap % cover == 0) {
        answer += gap / cover;
    } else {
        answer += gap / cover + 1;
    }
     */


    // 테스트
    public static void main(String[] args) {
        int n1 = 11;
        int[] stations1 = {4, 11};
        int w1 = 1;
        System.out.println(solution(n1, stations1, w1));

        int n2 = 16;
        int[] stations2 = {9};
        int w2 = 2;
        System.out.println(solution(n2, stations2, w2));
    }
}