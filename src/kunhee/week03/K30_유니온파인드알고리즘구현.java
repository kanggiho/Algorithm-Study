package kunhee.week03;

import java.util.*;

public class K30_유니온파인드알고리즘구현 {

    static int[] parent; // 전역 변수로 parent 선언

    public static List<Boolean> solution(int k, int[][] operations) {
        parent = new int[k]; // 전역 배열 초기화

        List<Boolean> result = new ArrayList<>();

        // 1. 초기 노드 설정
        for (int i = 0; i < k; i++) {
            parent[i] = i;
        }

        // 2. 연산 처리
        for (int[] operation : operations) {
            int type = operation[0];
            int a = operation[1];
            int b = operation[2];

            if (type == 0) {
                union(a, b);
            } else {
                result.add(find(a) == find(b));
            }
        }

        return result;
    }

    // find: 경로 압축
    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // 경로 압축
        }
        return parent[x];
    }

    // union: 더 작은 값을 대표 노드로
    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return;

        if (rootA < rootB) {
            parent[rootB] = rootA;
        } else {
            parent[rootA] = rootB;
        }
    }

    // 책의 답안에서 크기 비교?
    // 제약조건에서 3번 문장의 뜻?
    // 여기서는 각 집합의 루트 노드를 기준으로 루트 노드가 작은 노드를 더 큰 노드의 자식으로 연결하는 방법을 사용합니다. --> ?

}
