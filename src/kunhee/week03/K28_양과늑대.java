package kunhee.week03;

import java.util.*;

public class K28_양과늑대 {

    static List<Integer>[] graph;
    static int maxSheep = 0;

    public static int solution(int[] info, int[][] edges) {
        int n = info.length;
        graph = new ArrayList[n];

        // 트리를 먼저 만든다
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            graph[parent].add(child);
        }

        List<Integer> canVisit = new ArrayList<>();
        canVisit.add(0); // 시작은 루트

        dfs(0, 0, 0, canVisit, info);

        return maxSheep;
    }

    static void dfs(int node, int sheep, int wolf, List<Integer> canVisit, int[] info) {
        // 양, 늑대 수 갱신
        if (info[node] == 0) sheep++;
        else wolf++;

        if (wolf >= sheep) return; // 늑대가 더 많아지면 종료

        maxSheep = Math.max(maxSheep, sheep);

        // 현재 시점에서 갈 수 있는 노드 후보
        List<Integer> nextNodes = new ArrayList<>(canVisit);

        // 지금 방문할 노드 제거
        nextNodes.remove(Integer.valueOf(node));

        // 방문한 노드의 자식들 추가
        nextNodes.addAll(graph[node]);

        for (int next : nextNodes) {
            dfs(next, sheep, wolf, nextNodes, info);
        }
    }

}
