package jino.week6;

import java.util.ArrayList;
import java.util.List;

public class J42_전력망둘로나누기 {
    

    class Solution {
        private static int answer;
        private static List<Integer>[] A;
        private static boolean[] visited;

        public int solution(int n, int[][] wires) {
            //초기화
            answer = Integer.MAX_VALUE;
            A = new ArrayList[n+1];
            visited = new boolean[n+1];

            for(int i = 1 ; i < n + 1 ; i++){
                A[i] = new ArrayList<>();
            }
            for(int[] arr : wires){
                A[arr[0]].add(arr[1]);
                A[arr[1]].add(arr[0]);
            }
            DFS(1,n);

            return answer;
        }

        private static int DFS(int n, int node){
            visited[n] = true;
            int child = 0;
            for(int next : A[n]){
                if(!visited[next]){
                    int result = DFS(next, node);
                    answer = Math.min(answer, Math.abs(node - (2 * result)));
                    child += result;

                }
            }
            return child + 1;
        }
    }
}
