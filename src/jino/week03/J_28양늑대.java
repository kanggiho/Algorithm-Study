package jino.week03;

import java.util.ArrayList;

public class J_28양늑대 {
    

    class Solution {
        private static ArrayList<Integer>[] Graph = new ArrayList[17];//인접리스트 문제
        private static int [] Node;//양 늑대 저장
        private static boolean[][][] visited;
        private static int Maxs;

        public int solution(int[] info, int[][] edges) {
            int answer = 0;
            Node = info;

            for(int i = 0 ; i < Node.length ; i++){
                Graph[i] = new ArrayList<Integer>();
            }
            for(int[] edge :edges ){
                Graph[edge[0]].add(edge[1]);
            }

            visited = new boolean[17][18][18];
            Maxs = 0;
            DFS(0,0,0);

            return Maxs;
        }
        private static void DFS(int pos ,int s ,int w){
            visited[pos][s][w] = true;

            int backupNode = Node[pos];

            if(Node[pos] == 0){
                s++;
            }
            else if(Node[pos] == 1){
                w++;
            }
            Node[pos] = -1;

            if(w < s){
                Maxs = Math.max(s,Maxs);

                for(int next : Graph[pos]){
                    DFS(next,s,w);
                }

                for(int i = 0 ; i < Node.length ; i++){
                    if(Node[i] == -1 ){
                        for(int next : Graph[i]){
                            if(Node[next] != -1){
                                DFS(next,s,w);
                            }
                        }
                    }
                }
            }
            Node[pos] =backupNode;
            visited[pos][s][w] = false;
        }
    }
}
