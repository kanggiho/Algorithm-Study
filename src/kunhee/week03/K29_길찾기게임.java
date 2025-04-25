package kunhee.week03;

import java.util.*;

public class K29_길찾기게임 {

    static List<Integer> preList = new ArrayList<>();
    static List<Integer> postList = new ArrayList<>();

    public static int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        Node[] nodes = new Node[n];

        // 1. Node 배열 생성 (x, y, index)
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1);
        }

        // 2. y 내림차순, x 오름차순 정렬
        Arrays.sort(nodes, (a, b) -> {
            if (b.y == a.y) return a.x - b.x;
            return b.y - a.y;
        });

        // 3. 트리 구성
        Node root = nodes[0];
        for (int i = 1; i < n; i++) {
            root.insert(nodes[i]);
        }

        // 4. 전위 순회
        preorder(root);
        // 5. 후위 순회
        postorder(root);

        // 6. 결과 반환
        int[][] answer = new int[2][n];
        for (int i = 0; i < n; i++) {
            answer[0][i] = preList.get(i);
            answer[1][i] = postList.get(i);
        }
        return answer;
    }

    static class Node {
        int x, y, index;
        Node left, right;

        Node(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }

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

    static void preorder(Node node) {
        if (node == null) return;
        preList.add(node.index);
        preorder(node.left);
        preorder(node.right);
    }

    static void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        postList.add(node.index);
    }

}
