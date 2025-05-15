package giho.week04;

import java.util.*;

public class G37_게임맵최단거리 {


    // 동 남 서 북
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};


    public int solution(int[][] maps) {
        // 맵 크기 저장
        final int N = maps.length;
        final int M = maps[0].length;

        // 각 위치별 거리
        int[][] dist = new int[N][M];

        Deque<int[]> deque = new ArrayDeque<>();

        deque.addLast(new int[]{0, 0});
        dist[0][0] = 1;

        while (!deque.isEmpty()) {

            int[] temp = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int tr = temp[0] + dx[i];
                int tc = temp[1] + dy[i];

                if (tr < 0 || tc < 0 || tr >= N || tc >= M) {
                    continue;
                }

                if (maps[tr][tc] == 0) {
                    continue;
                }

                if (dist[tr][tc] == 0) {
                    deque.addLast(new int[]{tr, tc});
                    dist[tr][tc] = dist[temp[0]][temp[1]] + 1;
                }

            }

        }

        return dist[N - 1][M - 1] == 0 ? -1 : dist[N - 1][M - 1];
    }

}
