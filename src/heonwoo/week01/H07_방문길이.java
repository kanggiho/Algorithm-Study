package heonwoo.week01;

public class H07_방문길이 {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    public static void main(String[] args) {
        String dirs = "ULURRDLLU";
        int answer = solution(dirs);
        System.out.println(answer);
    }

    public static int solution(String dirs) {
        boolean[][][] visited = new boolean[11][11][4]; // 0: 상, 1: 우, 2: 하, 3: 좌
        int y = 5, x = 5, d = 0;
        int answer = 0;

        for (char c : dirs.toCharArray()) {
            if (c == 'U') d = 0;
            if (c == 'R') d = 1;
            if (c == 'D') d = 2;
            if (c == 'L') d = 3;

            int ny = y + dy[d];
            int nx = x + dx[d];
            if (ny < 0 || ny >= 11 || nx < 0 || nx >= 11) continue; //판을 벗어난경우 무시
            if (!visited[ny][nx][d]) {
                visited[ny][nx][d] = true;
                visited[y][x][(d + 2) % 4] = true;
                answer++;
            }
            y = ny;
            x = nx;
        }

        return answer;
    }
}
