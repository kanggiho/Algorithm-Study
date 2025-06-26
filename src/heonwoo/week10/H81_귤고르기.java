package heonwoo.week10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

public class H81_귤고르기 {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        ArrayList<Integer> sortedCounts = new ArrayList<>(map.values());
        sortedCounts.sort(Collections.reverseOrder());

        int numTypes = 0; // 현재까지의 종류 수
        int countSum = 0; // 현재까지의 귤 개수 합

        for (int count : sortedCounts) {
            countSum += count;
            numTypes++;

            // 귤 개수 합이 k 이상이 되는 순간 종료
            if (countSum >= k)
                break;
        }
        return numTypes;
    }
}
