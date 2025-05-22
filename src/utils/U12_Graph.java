package utils;

import java.util.*;

public class U12_Graph {

    private List<Integer>[] graph;
    private boolean[] visited;
    private int n; // 노드 개수

    // 생성자: 노드 수 초기화 및 그래프 생성
    public U12_Graph(int n) {
        this.n = n;
        graph = new ArrayList[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    // 간선 추가
    public void addEdge(int from, int to) {
        graph[from].add(to);
        // graph[to].add(from); // 무방향 그래프일 경우 주석 해제
    }

    // 방문 배열 초기화
    private void resetVisited() {
        Arrays.fill(visited, false);
    }

    // ✅ 재귀 DFS
    public void recursiveDFS(int node) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int next : graph[node]) {
            if (!visited[next]) {
                recursiveDFS(next);
            }
        }
    }

    // ✅ 스택 DFS
    public void stackDFS(int start) {
        resetVisited();
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                visited[node] = true;
                System.out.print(node + " ");

                // 인접 노드를 뒤부터 넣어야 앞에서 방문됨
                List<Integer> neighbors = graph[node];
                for (int i = neighbors.size() - 1; i >= 0; i--) {
                    int next = neighbors.get(i);
                    if (!visited[next]) {
                        stack.push(next);
                    }
                }
            }
        }
    }

    // ✅ BFS
    public void bfs(int start) {
        resetVisited();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int next : graph[node]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }

    // 예시 실행
    public static void main(String[] args) {
        U12_Graph g = new U12_Graph(6); // 노드 0~5
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);

        System.out.println("재귀 DFS:");
        g.resetVisited();
        g.recursiveDFS(0);
        System.out.println();

        System.out.println("스택 DFS:");
        g.stackDFS(0);
        System.out.println();

        System.out.println("BFS:");
        g.bfs(0);
        System.out.println();
    }
}
