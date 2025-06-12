package kunhee.week06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class k48_외벽점검 {

    public int solution(int n, int[] weak, int[] dist) {
        Arrays.sort(dist);
        reverse(dist); // 큰 값부터

        for (int i = 1; i <= dist.length; i++) {
            int[] selected = Arrays.copyOf(dist, i);
            if (greedyCheck(n, weak, selected)) return i;
        }

        return -1;
    }

    private boolean greedyCheck(int n, int[] weak, int[] selected) {
        List<Integer> currentWeak = new ArrayList<>();
        for (int j : weak) {
            currentWeak.add(j);
        }

        int idx = 0;
        while (idx < selected.length && !currentWeak.isEmpty()) {
            int distance = selected[idx];
            int maxCover = 0;
            int bestStart = -1;

            for (int start = 0; start <= n - distance; start++) {
                int end = start + distance;
                int covered = 0;

                for (int w : currentWeak) {
                    if (w >= start && w <= end) covered++;
                }

                if (covered > maxCover) {
                    maxCover = covered;
                    bestStart = start;
                }
            }

            if (bestStart == -1) break;

            final int fs = bestStart, fe = bestStart + distance;
            currentWeak.removeIf(w -> (w >= fs && w <= fe) || (w + n >= fs && w + n <= fe));
            idx++;
        }

        return currentWeak.isEmpty();
    }

    private void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = tmp;
        }
    }

}
