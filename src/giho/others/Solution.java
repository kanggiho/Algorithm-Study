package giho.others;

import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        // 현재 트럭에 있는 상자 수
        int nowCap = cap;


        int total = deliveriesCheck(deliveries) + deliveriesCheck(pickups);
        int dtotal = deliveriesCheck(deliveries);
        int ptotal = deliveriesCheck(pickups);

        while (total > 0) {
            int dDist = 0; // 이번 배송에 사용한 거리
            int pDist = 0; // 이번 수거에 사용한 거리

            // 필요한 상자만 가지고 출발하기
            if (dtotal < cap) {
                nowCap = dtotal;
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
                        dtotal -= deliveries[i];
                        deliveries[i] = 0;
                    } else {
                        deliveries[i] -= nowCap;
                        total -= nowCap;
                        dtotal -= nowCap;
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
                        ptotal -= pickups[i];
                        pickups[i] = 0;
                    } else {
                        pickups[i] -= cap - nowCap;
                        total -= cap - nowCap;
                        ptotal -= cap - nowCap;
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
    public int deliveriesCheck(int[] arr) {
        int result = 0;
        for (int a : arr) {
            result += a;
        }
        return result;
    }
}