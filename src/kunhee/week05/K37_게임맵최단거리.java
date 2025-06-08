package kunhee.week05;

import java.util.LinkedList;
import java.util.Queue;

public class K37_게임맵최단거리 {

    public static int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        // 이동 방향: 동, 서, 남, 북
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        // 방문 여부와 거리 저장
        int[][] dist = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        dist[0][0] = 1; // 시작 지점도 1칸

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            // 네 방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 맵 범위 밖이거나, 벽이거나, 이미 방문했다면 스킵
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (maps[nx][ny] == 0 || visited[nx][ny]) continue;

                // 이동 가능할 경우
                visited[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
                queue.add(new int[]{nx, ny});
            }
        }

        // 도착점에 도달 못한 경우
        return dist[n - 1][m - 1] == 0 ? -1 : dist[n - 1][m - 1];
    }

}
