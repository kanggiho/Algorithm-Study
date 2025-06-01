package heonwoo.week03;

import java.util.*;

public class H30_간단한유니온파인드알고리즘구현 {
    public static void main(String[] args) {
        int[][] operations = {{0,0,1}, {0,1,2}, {1,1,2}};
        int k = 3;

        System.out.println(Arrays.toString(solution(k, operations)));
    }
    private static int[] parent;

    private static int find(int x) {
        if (parent[x] == x)
            return x;
        // 그렇지 않다면 x의 부모를 찾아서 parent[x]에 저장
        parent[x] = find(parent[x]);
        return parent[x];
    }

    private static void union(int x, int y) {
        int root1 = find(x);
        int root2 = find(y);
        parent[root2] = root1;
    }

    public static Boolean[] solution(int k, int[][] operations) {
        // 노드의 수 만큼 배열 생성
        parent = new int[k];
        // 처음에는 각 노드가 자기 자신을 부모로 가지도록 초기화
        for (int i = 0; i < k; i++) {
            parent[i] = i;
        }

        ArrayList<Boolean> answer = new ArrayList<>();

        for(int[] op : operations) {
            if (op[0] == 0) {
                union(op[1], op[2]);
            }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
            else {
                answer.add(find(op[1]) == find(op[2]));
            }
        }
        return answer.toArray(new Boolean[0]);
    }
}
