package kunhee.week02;

import java.util.HashSet;
import java.util.Set;

public class K18_두개의수로특정값만들기 {

    public static boolean solution(int[] arr, int target) {
        Set<Integer> seen = new HashSet<>();

        // for (int num : arr) {
        //     if (contains(arr, target - num)) return true;
        // }
        // -->
        // 문제점1) 배열 탐색 시 O(n^2) / 해시 contains()는 평균 O(1) → 전체 시간복잡도 O(n)
        // 문제점2) 배열에서 target - num이 존재하더라도, 그게 지금 num과 같은 요소일 수 있음

        for (int num : arr) {
            if (seen.contains(target - num)) {
                return true;
            }
            // 현재 수를 해시에 저장
            seen.add(num);
        }

        return false; // 끝까지 못 찾으면 false
    }

}
