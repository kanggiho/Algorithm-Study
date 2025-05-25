package kunhee.week05;

import java.util.*;

public class K41_경주로건설 {

    static int N;
    static int[][] board;
    static int[][][] cost;
    static int[] dx = {0, 1, 0, -1}; // 동, 남, 서, 북
    static int[] dy = {1, 0, -1, 0};

    public static int solution(int[][] inputBoard) {
        board = inputBoard;
        N = board.length;
        cost = new int[N][N][4];

        for (int[][] layer : cost) {
            for (int[] row : layer) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
        }

        Queue<Node> queue = new LinkedList<>();

        // 시작 위치에서 동, 남 방향으로만 초기화
        for (int d = 0; d < 2; d++) {
            int nx = dx[d];
            int ny = dy[d];
            if (isIn(nx, ny) && board[nx][ny] == 0) {
                cost[nx][ny][d] = 100;
                queue.offer(new Node(nx, ny, d, 100));
            }
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = node.x + dx[d];
                int ny = node.y + dy[d];
                if (!isIn(nx, ny) || board[nx][ny] == 1) continue;

                int nextCost = node.cost + (node.dir == d ? 100 : 600);

                if (cost[nx][ny][d] > nextCost) {
                    cost[nx][ny][d] = nextCost;
                    queue.offer(new Node(nx, ny, d, nextCost));
                }
            }
        }

        return Arrays.stream(cost[N - 1][N - 1]).min().getAsInt();
    }

    static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    static class Node {
        int x, y, dir, cost;

        Node(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }

}
