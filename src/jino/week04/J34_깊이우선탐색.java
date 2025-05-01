package jino.week04;

import java.util.ArrayList;
import java.util.Arrays;

public class J34_깊이우선탐색 {
    

    // The main method must be in a class named "Main".
    class Main {
        private static boolean visited[];
        private static ArrayList<Integer> [] A;
        private static ArrayList<Integer> answer;
        public static void main(String[] args) {
            System.out.println(Arrays.toString(solution(new int[][]{ {1, 2}, {2, 3}, {3, 4}, {4, 5} }, 1 , 5)));
            System.out.println(Arrays.toString(solution(new int[][]{ {1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {5, 6} }, 1, 6)));
        }

        private static int[] solution(int[][] graph, int start ,int node){
            //초기화

            A = new ArrayList[node +1];
            for(int i = 1 ; i <= node ;i++){
                A[i] = new ArrayList<>();
            }
            for(int i = 0 ; i < graph.length  ;i++){
                A[graph[i][0]].add(graph[i][1]);
                A[graph[i][1]].add(graph[i][0]);
            }
            answer = new ArrayList<>();
            visited = new boolean[node + 1];

            DFS(start);
            int[] result = answer.stream()
                    .mapToInt(i -> i)
                    .toArray();

            return result;
        }
        private static void DFS(int start){
            visited[start] = true;
            answer.add(start);
            for(int i : A[start]){
                if(!visited[i]){
                    DFS(i);
                }
            }
        }
    }
}
