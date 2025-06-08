package giho.week06;

import java.util.*;

public class G57_지형이동 {

    public static class Node {
        int x, y, cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    public int solution(int[][] land, int height) {

        int answer = 0;

        int n = land.length;

        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};

        boolean[][] visited = new boolean[n][n];

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(0, 0, 0));


        while (!pq.isEmpty()) {
            Node temp = pq.poll();

            if (visited[temp.x][temp.y]) {
                continue;
            }

            visited[temp.x][temp.y] = true;

            answer+=temp.cost;

            for (int i = 0; i < 4; i++) {
                int nx = temp.x+dx[i];
                int ny = temp.y+dy[i];

                if(!(0<=nx&&nx<n&&0<=ny&&ny<n)){
                    continue;
                }
                int tempCost = Math.abs(land[nx][ny]-land[temp.x][temp.y]);
                int newCost = tempCost>height?tempCost:0;

                pq.add(new Node(nx,ny,newCost));

            }

        }


        return answer;
    }

}
