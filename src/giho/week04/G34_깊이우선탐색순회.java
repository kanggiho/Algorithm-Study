package giho.week04;

import java.util.*;

public class G34_깊이우선탐색순회 {

    public static boolean[] visited;
    public static ArrayList<Integer>[] adjList;

    public static ArrayList<Integer> answer;


    public static void main(String[] args) {
        int[][] graph1 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int[][] graph2 = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {5, 6}};
        Arrays.stream(solution(graph1, 1, 5)).forEach(System.out::println);
        Arrays.stream(solution(graph2, 1, 6)).forEach(System.out::println);
    }


    public static int[] solution(int[][] graph, int start, int n) {
        adjList = new ArrayList[n + 1];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : graph) {
            adjList[edge[0]].add(edge[1]);
        }

        visited = new boolean[n + 1];
        answer = new ArrayList<>();

        dfs(start);


        return answer.stream().mapToInt(i -> i).toArray();
    }

    public static void dfs(int temp) {
        visited[temp] = true;
        answer.add(temp);

        for (int next : adjList[temp]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
