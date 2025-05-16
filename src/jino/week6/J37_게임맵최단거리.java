package jino.week6;

import java.util.ArrayDeque;
import java.util.Deque;

public class J37_게임맵최단거리 {

    class Solution {
        private static Deque<int[]> myQueue;
        private static boolean[][] visited;
        private static int[] dx = {0, 0, 1, -1};//동 서 남 북 열이동
        private static int[] dy = {1, -1, 0, 0};//행이동
        private static int n;
        private static int m;

        public int solution(int[][] maps) {
            //초기화
            int answer = 0;
            myQueue = new ArrayDeque<>();
            n = maps.length;
            m = maps[0].length;
            visited = new boolean[n][m];
            BFS(0 ,0 ,maps);
            if(visited[n-1][m-1] == false){
                answer = -1;
            }
            else{
                answer = maps[n-1][m-1];
            }

            return answer;
        }

        private static void BFS(int x , int y,int[][]maps){
            myQueue.add(new int[]{x,y});
            visited[x][y] = true;
            while(!myQueue.isEmpty()){
                int[] now = myQueue.poll();
                for(int i = 0 ; i < 4 ; i++){
                    int nx = now[0] + dx[i];
                    int ny = now[1] + dy[i];
                    if(nx < n && ny < m && nx > -1 && ny > -1 && maps[nx][ny] != 0 && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        maps[nx][ny] = maps[now[0]][now[1]] +1;
                        myQueue.add(new int[]{nx,ny});
                    }
                    if(nx == n && ny == m){
                        return;
                    }
                }
            }

        }
    }
}
