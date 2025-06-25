package giho.week08;

import java.util.*;

public class G82_기지국설치 {

    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int width = 2 * w + 1;
        int min = stations[0] - w;
        int max = stations[0] + w;
        int next_min;
        int next_max;

        ArrayList<Integer> blank = new ArrayList<>();


        if (stations.length == 1) {
            if (min > 1) {
                blank.add(min - 1);
            }
            if (max < n) {
                blank.add(n - max);
            }
        } else {

            min = stations[0] - w;

            if (min > 1) {
                blank.add(min - 1);
            }


            for (int i = 0; i < stations.length - 1; i++) {

                min = stations[i] - w;
                max = stations[i] + w;
                next_min = stations[i + 1] - w;
                next_max = stations[i + 1] + w;
                if (next_min > max + 1) {
                    blank.add(next_min - max - 1);
                }
            }

            max = stations[stations.length - 1] + w;

            if (max < n) {
                blank.add(n - max);
            }
        }

        for (int i = 0; i < blank.size(); i++) {
            answer += blank.get(i) / width + 1;
            if (blank.get(i) % width == 0) {
                answer--;
            }
        }
        return answer;
    }

}
