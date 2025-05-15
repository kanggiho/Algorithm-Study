package giho.week04;

import java.util.*;

public class G36_다익스트라알고리즘 {

    public static class Edge {
        int to, weight;
        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static ArrayList<Edge>[] graph;
    static int[] dist;

    public static void dijkstra(int start, int n) {
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.offer(new Edge(start, 0));


        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int now = current.to;

            // 이미 처리한 적이 있다면 스킵
            if (current.weight > dist[now]) continue;

            for (Edge next : graph[now]) {
                if (dist[next.to] > dist[now] + next.weight) {
                    dist[next.to] = dist[now] + next.weight;
                    pq.offer(new Edge(next.to, dist[next.to]));
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[1].add(new Edge(2, 2));
        graph[1].add(new Edge(3, 5));
        graph[2].add(new Edge(3, 1));
        graph[2].add(new Edge(4, 2));
        graph[3].add(new Edge(4, 3));
        graph[4].add(new Edge(5, 1));

        dijkstra(1, n);
    }


}
