package heonwoo.week05;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class H42_전력망을둘로나누기 {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {
            List<Integer>[] graph = new ArrayList[n + 1];
            for (int j = 1; j <= n; j++) graph[j] = new ArrayList<>();

            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue;
                int a = wires[j][0];
                int b = wires[j][1];
                graph[a].add(b);
                graph[b].add(a);
            }

            int count = bfs(1, graph, n);
            int diff = Math.abs((n - count) - count);
            answer = Math.min(answer, diff);
        }

        return answer;
    }

    private int bfs(int start, List<Integer>[] graph, int n) {
        boolean[] visited = new boolean[n + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offerLast(start);
        visited[start] = true;

        int count = 1;

        while (!queue.isEmpty()) {
            int cur = queue.pollFirst();
            for (int next : graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offerLast(next);
                    count++;
                }
            }
        }

        return count;
    }
}
