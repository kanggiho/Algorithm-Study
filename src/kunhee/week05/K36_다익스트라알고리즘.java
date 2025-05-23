package kunhee.week05;

import java.util.*;

public class K36_다익스트라알고리즘 {

    public static int[] solution(int[][] graph, int start, int n) {
        // 1. 인접 리스트 생성
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : graph) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            adj.get(from).add(new int[]{to, weight});
        }

        // 2. 최단 거리 배열 초기화
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        // 3. 우선순위 큐: [현재까지의 거리, 노드 번호]
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, start});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int curDist = current[0];
            int node = current[1];

            // 이미 더 짧은 거리로 방문했으면 패스
            if (curDist > dist[node]) continue;

            // 인접 노드 확인
            for (int[] neighbor : adj.get(node)) {
                int next = neighbor[0];
                int cost = neighbor[1];

                if (dist[next] > dist[node] + cost) {
                    dist[next] = dist[node] + cost;
                    pq.offer(new int[]{dist[next], next});
                }
            }
        }

        return dist;
    }

}
