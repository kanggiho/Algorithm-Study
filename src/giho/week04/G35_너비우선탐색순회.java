package giho.week04;

import java.util.*;


public class G35_너비우선탐색순회 {
    public static boolean[] visited;
    public static ArrayList<Integer>[] adjList;

    public static ArrayList<Integer> answer;


    public static void main(String[] args) {
        int[][] graph1 = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {3, 7}, {4, 8}, {5, 8}, {6, 9}, {7, 9}};
        int[][] graph2 = {{1, 3}, {3, 4}, {3, 5}, {5, 2}};
        Arrays.stream(solution(graph1, 1, 9)).forEach(System.out::println);
        Arrays.stream(solution(graph2, 1, 5)).forEach(System.out::println);
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

        bfs(start);


        return answer.stream().mapToInt(i -> i).toArray();
    }

    public static void bfs(int temp) {

        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(temp);
        visited[temp] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();
            answer.add(now);

            for (int next : adjList[now]){
                queue.add(next);
                visited[next] = true;
            }
        }
    }
}
