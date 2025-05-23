package kunhee.week05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class K33_섬연결하기 {

    public int solution(int n, int[][] costs) {
        // 간선 정보 정렬 (비용 오름차순)
        Arrays.sort(costs, Comparator.comparingInt(o -> o[2]));

        // Union-Find용 부모 배열 초기화
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        int answer = 0;
        int edges = 0;

        for (int[] cost : costs) {
            int a = cost[0];
            int b = cost[1];
            int c = cost[2];

            // 사이클이 없으면 연결
            if (union(parent, a, b)) {
                answer += c;
                edges++;
                if (edges == n - 1) break; // 최소 신장 트리
            }
        }

        return answer;
    }

    // 루트 찾기
    private int find(int[] parent, int x) {
        if (parent[x] != x)
            parent[x] = find(parent, parent[x]); // 경로 압축
        return parent[x];
    }

    // 합치기
    private boolean union(int[] parent, int a, int b) {
        int rootA = find(parent, a);
        int rootB = find(parent, b);
        if (rootA == rootB) return false; // 이미 연결됨
        parent[rootB] = rootA;
        return true;
    }

}
