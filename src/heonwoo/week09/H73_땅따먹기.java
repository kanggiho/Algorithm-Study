package heonwoo.week09;

import java.util.Arrays;

public class H73_땅따먹기 {
    int solution(int[][] land) {
        for (int i = 1; i < land.length; i++) {
            for (int j = 1; j < 4; j++) {
                int max = 0;
                for (int k = 0; k < 4; k++) {
                    if (j != k) max = Math.max(max, land[i - 1][k]);
                }
                land[i][j] += max;
            }
        }
        return Arrays.stream(land[land.length - 1]).max().getAsInt();
    }
}
