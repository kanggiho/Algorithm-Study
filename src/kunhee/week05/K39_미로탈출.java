package kunhee.week05;

import java.util.*;

public class K39_미로탈출 {

    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        map = new char[N][M];

        int startX = 0, startY = 0;
        int leverX = 0, leverY = 0;
        int exitX = 0, exitY = 0;

        // 맵 구성 및 좌표 찾기
        for (int i = 0; i < N; i++) {
            map[i] = maps[i].toCharArray();
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'S') {
                    startX = i; startY = j;
                } else if (map[i][j] == 'L') {
                    leverX = i; leverY = j;
                } else if (map[i][j] == 'E') {
                    exitX = i; exitY = j;
                }
            }
        }

        int toLever = bfs(startX, startY, 'L'); // S -> L
        if (toLever == -1) return -1;

        int toExit = bfs(leverX, leverY, 'E');  // L -> E
        if (toExit == -1) return -1;

        return toLever + toExit;
    }

    // 목표 문자를 찾는 BFS
    private static int bfs(int x, int y, char target) {
        visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y, 0});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            int dist = cur[2];

            if (map[cx][cy] == target) return dist;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visited[nx][ny] || map[nx][ny] == 'X') continue;

                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny, dist + 1});
            }
        }

        return -1; // 목표 지점 도달 실패
    }

}
