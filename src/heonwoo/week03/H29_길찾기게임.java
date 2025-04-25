package heonwoo.week03;

import java.util.*;

public class H29_길찾기게임 {
    public static void main(String[] args) {
        int[][] nodeinfo = {
                {5, 3},
                {11, 5},
                {13, 3},
                {3, 5},
                {6, 1},
                {1, 3},
                {8, 6},
                {7, 2},
                {2, 2}
        };

        int[][] result = solution(nodeinfo);

        System.out.println("전위 순회: " + Arrays.toString(result[0]));
        System.out.println("후위 순회: " + Arrays.toString(result[1]));
    }

    // 노드 제작
    static class Node {
        int x, y, index;
        Node left, right;

        Node(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }

        // 이진 트리 삽입 규칙: x좌표 기준
        void insert(Node child) {
            if (child.x < this.x) {
                if (this.left == null) this.left = child;
                else this.left.insert(child);
            } else {
                if (this.right == null) this.right = child;
                else this.right.insert(child);
            }
        }
    }

    static List<Integer> preOrderList = new ArrayList<>();
    static List<Integer> postOrderList = new ArrayList<>();

    public static int[][] solution(int[][] nodeinfo) {
        List<Node> nodes = new ArrayList<>();

        // 1. 노드에 인덱스를 붙여 저장
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1));
        }

        // 2. y 내림차순, x 오름차순으로 인덱스 정렬
        nodes.sort((a, b) -> {
            if (a.y == b.y) return Integer.compare(a.x, b.x);
            return Integer.compare(b.y, a.y);
        });

        // 3. 트리 구성
        Node root = nodes.get(0);
        for (int i = 1; i < nodes.size(); i++) {
            root.insert(nodes.get(i));
        }

        // 4. 순회 결과 담기
        preOrder(root);
        postOrder(root);

        // 5. 결과 변환
        int n = nodeinfo.length;
        int[][] answer = new int[2][n];
        for (int i = 0; i < n; i++) {
            answer[0][i] = preOrderList.get(i);
            answer[1][i] = postOrderList.get(i);
        }

        return answer;
    }

    // 전위 순회 (루트 → 좌 → 우)
    private static void preOrder(Node node) {
        if (node == null) return;
        preOrderList.add(node.index);
        preOrder(node.left);
        preOrder(node.right);
    }

    // 후위 순회 (좌 → 우 → 루트)
    private static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        postOrderList.add(node.index);
    }
}
