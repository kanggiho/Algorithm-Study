package jino.week15;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class J_거리두기확인 {
    
    class Solution {
        private static String[][] room;
        private static int[] answer;
        private static boolean[][] visited;
        private static int[] dx= new int[]{-1, 0, 1, 0};//북,동,남,서
        private static int[] dy= new int[]{0, 1, 0, -1};//북,동,남,서
        private static Deque<int[]> dq;
        public int[] solution(String[][] places) {
            //초기화
            answer = new int[places.length];
            Arrays.fill(answer, 1);
            for(int i = 0 ; i< 5 ; i++){
                System.out.print(answer[i]);
            }
            for(int i = 0 ; i < 5 ; i++){//룸방 탐색
                room = new String[5][5];
                dq = new ArrayDeque<>();
                visited = new boolean[5][5];
                for(int j = 0 ; j < 5 ; j++){//룸방 만들기
                    for(int k = 0 ; k < 5 ;k++){
                        room[j][k] = places[i][j].charAt(k)+"";
                        if(room[j][k].equals("P")){
                            dq.add(new int[]{j, k});//j는 행 K 는열
                        }
                    }

                }
                while(!dq.isEmpty()){
                    int[] now = dq.poll();
                    int nowX = now[0];
                    int nowY = now[1];
                    bfs(nowX, nowY, 0, false, i,"");
                }
            }
            return answer;
        }
        private static void bfs(int nowX, int nowY, int dept, boolean flag, int index, String lastState){
            visited[nowX][nowY] = true;


            if(dept == 1 && room[nowX][nowY].equals("P")){
                answer[index] = 0;
                return;
            }

            if(dept == 2 && !lastState.equals("X") && room[nowX][nowY].equals("P")){
                answer[index] = 0;
                return;
            }
            if(dept >= 2){
                return;
            }
            visited[nowX][nowY] = true;
            for(int i = 0 ; i < 4 ; i++){
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                if(nextX >=0 && nextY >= 0 && nextX < 5 && nextY < 5 && !visited[nextX][nextY]){
                    bfs(nextX, nextY, dept + 1, flag, index,room[nowX][nowY]);
                }
            }
        }
    }

}
