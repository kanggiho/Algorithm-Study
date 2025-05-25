package kunhee.week05;

import java.util.*;

public class K42_전력망을둘로나누기 {

    public static int solution(int n, int[][] wires) {
        int minDiff = Integer.MAX_VALUE;

        // 각 wire를 끊어보며 시뮬레이션
        for (int i = 0; i < wires.length; i++) {
            // 그래프 초기화
            List<List<Integer>> graph = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                graph.add(new ArrayList<>());
            }

            // i번째 wire를 제외하고 그래프 구성
            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue;
                int a = wires[j][0];
                int b = wires[j][1];
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            // 연결된 노드 수 계산
            int count = bfs(graph, n, 1); // 아무 정점에서 탐색 시작
            int diff = Math.abs(n - count - count);
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }

    // BFS를 통해 한 트리의 노드 개수 계산
    private static int bfs(List<List<Integer>> graph, int n, int start) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        int count = 1;

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : graph.get(curr)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    count++;
                }
            }
        }

        return count;
    }

}
