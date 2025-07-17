package jino.week14;

import java.util.ArrayList;
import java.util.List;

public class J_양과늑대 {

    class Solution {
        private static int answer = 0;
        private static int[] Info;
        private static int[][]Edges;
        private static List<Integer>[] graph;
        private static boolean[][][] visited;
        public int solution(int[] info, int[][] edges) {
            Info = info;
            Edges = edges;
            graph = new ArrayList[info.length];
            for(int i = 0 ; i < info.length ; i++){
                graph[i] = new ArrayList<>();
            }
            for(int i = 0 ;i < edges.length ; i++){
                graph[edges[i][0]].add(edges[i][1]);
            }
            visited = new boolean[info.length][info.length + 1][info.length + 1];

            dfs(0, 0, 0);

            return answer;
        }
        private static void dfs(int now, int countS, int countW){
            int nowAnimal = Info[now];
            if(visited[now][countS][countW]) return;
            if(Info[now] == 0){//양
                countS++;
                Info[now] = -1;
            }
            else{
                countW++;
                Info[now] = -1;
            }
            visited[now][countS][countW] = true;
            if(countS > countW){
                answer = Math.max(answer, countS);
                for(int next : graph[now]){
                    dfs(next, countS, countW);
                }

                for(int i = 0 ; i < Info.length ; i++){
                    if(Info[i] == -1){
                        for(int next : graph[i]){
                            if(Info[next] != -1){
                                dfs(next, countS, countW);
                            }
                        }
                    }
                }
            }


            Info[now] = nowAnimal;
            visited[now][countS][countW] = false;

        }

    }
}
