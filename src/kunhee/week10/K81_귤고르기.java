package kunhee.week10;

// https://school.programmers.co.kr/learn/courses/30/lessons/138476

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class K81_귤고르기 {

    public static int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int tang : tangerine) {
            countMap.put(tang, countMap.getOrDefault(tang, 0) + 1);
        }

        int[] countArray = new int[countMap.size()];

        int i = 0;
        for (int count : countMap.values()) {
            countArray[i] = count;
            i++;
        }

        Arrays.sort(countArray);

        for (int j = countArray.length - 1; j >= 0; j--) {
            k -= countArray[j];
            answer++;
            if (k <= 0) break;
        }

        return answer;
    }

    // 테스트
    public static void main(String[] args) {
        int k1 = 6;
        int[] tangerine1 = {1, 3, 2, 5, 4, 5, 2, 3};
        System.out.println(solution(k1, tangerine1));

        int k2 = 4;
        int[] tangerine2 = {1, 3, 2, 5, 4, 5, 2, 3};
        System.out.println(solution(k2, tangerine2));

        int k3 = 2;
        int[] tangerine3 = {1, 1, 1, 1, 2, 2, 2, 3};
        System.out.println(solution(k3, tangerine3));
    }
}