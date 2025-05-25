package kunhee.week05;

import java.util.*;

public class K40_배달 {

    static List<int[]>[] graph;
    static int[] dist;

    public static int solution(int N, int[][] road, int K) {
        graph = new ArrayList[N + 1];
        dist = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        // 그래프 구성 (양방향)
        for (int[] r : road) {
            int a = r[0], b = r[1], cost = r[2];
            graph[a].add(new int[]{b, cost});
            graph[b].add(new int[]{a, cost});
        }

        dijkstra(1);

        // 거리 <= K인 마을 개수 세기
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) count++;
        }

        return count;
    }

    private static void dijkstra(int start) {
        // 배열의 두 번째 값(a[1])을 기준으로 오름차순 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        dist[start] = 0;
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0], cost = cur[1];

            if (dist[now] < cost) continue;

            for (int[] next : graph[now]) {
                int nextNode = next[0], nextCost = next[1];

                if (dist[nextNode] > dist[now] + nextCost) {
                    dist[nextNode] = dist[now] + nextCost;
                    pq.offer(new int[]{nextNode, dist[nextNode]});
                }
            }
        }
    }

}
