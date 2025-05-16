package jino.week6;

import java.util.ArrayDeque;
import java.util.Deque;

public class J39_미로탈출 {
    //합계: 30.4 / 100.0 맞음 ** 개선이 필요함!
    class Solution {
        private static char[][] towMap;
        private static int[][]cMap;
        private static boolean[][] visited;
        private static int[] dx = {0, 0, 1, -1};
        private static int[] dy = {1, -1, 0, 0};
        private static boolean lFlag = false;
        private static boolean eFlag = false;
        private static int answer = 0;
        private static int time = 0;
        private static Deque<int[]> dq;
        private static int startX = 0;
        private static int startY = 0;
        private static int endX = 0;
        private static int endY = 0;
        private static int xSize = 0;
        private static int ySize = 0;
        public int solution(String[] maps) {
            //초기화
            xSize = maps.length;
            ySize = maps[0].length();
            towMap = new char[maps.length][maps[0].length()];
            for(int i = 0 ; i < maps.length ; i++){
                for(int j = 0 ; j <maps[0].length();j++ ){
                    towMap[i][j] = maps[i].charAt(j);
                    if(maps[i].charAt(j) == 'S'){
                        startX = i;
                        startY = j;
                    }
                }
            }

            cMap = new int[maps.length][maps[0].length()];
            visited = new boolean[maps.length][maps[0].length()];
            dq = new ArrayDeque<>();
            BFS(startX, startY);
            if(lFlag && eFlag){
                answer = cMap[endX][endY];
            }
            else if(!eFlag){
                answer = -1;
            }

            return answer;
        }

        private static void BFS(int x,int y){
            dq.add(new int[]{x, y});
            visited[x][y] = true;
            while(!dq.isEmpty()){
                int[] now = dq.poll();
                for(int i = 0 ; i < 4 ; i++){
                    int nextX = now[0] + dx[i];
                    int nextY = now[1] + dy[i];//행이동
                    //못가는 조건 입력
                    //1.방문을 해버림
                    //2.범위 밖임
                    //3.X여버림

                    if(nextX >= 0 && nextY >= 0
                            && nextX < xSize && nextY < ySize
                            && !visited[nextX][nextY]
                            && towMap[nextX][nextY] != 'X'){
                        visited[nextX][nextY] = true;
                        cMap[nextX][nextY] = cMap[now[0]][now[1]] + 1;
                        if(towMap[nextX][nextY] == 'L'){
                            lFlag = true;
                        }
                        if(lFlag && towMap[nextX][nextY] == 'E'){
                            endX = nextX;
                            endY = nextY;
                            eFlag = true;
                            return;
                        }

                        dq.add(new int[]{nextX, nextY});
                    }
                }
            }
        }
    }
}
