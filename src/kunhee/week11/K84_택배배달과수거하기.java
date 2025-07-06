package kunhee.week11;

// https://school.programmers.co.kr/learn/courses/30/lessons/150369

public class K84_택배배달과수거하기 {

    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        // 현재 트럭에 있는 상자 수
        int nowCap = cap;

        int total = deliveriesCheck(deliveries) + deliveriesCheck(pickups);

        while (total > 0) {
            int dDist = 0; // 이번 배송에 사용한 거리
            int pDist = 0; // 이번 수거에 사용한 거리

            // 필요한 상자만 가지고 출발하기
            if (deliveriesCheck(deliveries) < cap) {
                nowCap = deliveriesCheck(deliveries);
            } else {
                nowCap = cap;
            }

            // 배송
            for (int i = n - 1; i >= 0; i--) {
                if (deliveries[i] != 0 && nowCap > 0) {

                    if (dDist == 0) {
                        dDist += i + 1;
                    }

                    if (deliveries[i] <= nowCap) {
                        nowCap -= deliveries[i];
                        total -= deliveries[i];
                        deliveries[i] = 0;
                    } else {
                        deliveries[i] -= nowCap;
                        total -= nowCap;
                        nowCap = 0;
                    }
                }
            }

            // 수거
            for (int i = n - 1; i >= 0; i--) {
                if (pickups[i] != 0 && nowCap <= cap) {

                    if (pDist == 0) {
                        pDist += i + 1;
                    }

                    if (pickups[i] <= cap - nowCap) {
                        nowCap += pickups[i];
                        total -= pickups[i];
                        pickups[i] = 0;
                    } else {
                        pickups[i] -= cap - nowCap;
                        total -= cap - nowCap;
                        nowCap = cap;
                    }
                }
            }

            // 배송/수거 중 더 멀리 다녀온 거리로 왕복 거리 계산
            answer += 2 * Math.max(dDist, pDist);
        }

        return answer;
    }

    // 배열 모든 요소의 합 구하기
    public static int deliveriesCheck(int[] arr) {
        int result = 0;
        for (int a : arr) {
            result += a;
        }
        return result;
    }

    public static void main(String[] args) {
        // 테스트 케이스 1
        int cap1 = 4;
        int n1 = 5;
        int[] deliveries1 = {1, 0, 3, 1, 2};
        int[] pickups1 = {0, 3, 0, 4, 0};
        long result1 = solution(cap1, n1, deliveries1, pickups1);
        System.out.println(result1);  // 예상 출력: 16

        // 테스트 케이스 2
        int cap2 = 2;
        int n2 = 7;
        int[] deliveries2 = {1, 0, 2, 0, 1, 0, 2};
        int[] pickups2 = {0, 2, 0, 1, 0, 2, 0};
        long result2 = solution(cap2, n2, deliveries2, pickups2);
        System.out.println(result2);  // 예상 출력: 30
    }
}