package jino.week6;

import java.util.ArrayList;
import java.util.List;

public class J38_네트워크 {
    
    class Solution {
        private static List<Integer>[] A ;
        private static boolean[] visited;
        private static int answer = 0;

        public int solution(int n, int[][] computers) {
            //초기화
            visited = new boolean[n];
            A = new ArrayList[n];
            for(int i = 0 ; i < n ; i++){
                A[i] = new ArrayList<>();
            }

            for(int i = 0 ; i < computers.length ; i++){
                for (int j = 0 ; j < computers[0].length; j++){
                    if(i == j) continue;
                    if(computers[i][j] == 1){
                        A[i].add(j);

                    }
                }
            }
            // for(int i = 0 ; i < n ; i++){
            //     DFS(i);
            // }
            for(int i = 0 ; i < n ; i++){
                if(!visited[i]){
                    DFS(i);
                    answer++;
                }

            }


            return answer;
        }

        private static void DFS(int n){
            visited[n] = true;
            for(int i :A[n]){
                if(!visited[i]){
                    DFS(i);
                }
            }
        }
    }

}
