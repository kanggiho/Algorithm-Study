package jino.week13;

import java.util.*;

public class J_미로탈출명령어 {


    class Solution {
        private static int maps[][];
        private static int[] dx =new int[]{1, 0 ,0, -1};//남, 서, 동, 북
        private static int[] dy= new int[]{0, -1, 1, 0};
        private static int K;
        private static int R;
        private static int C;
        private static String answer = "impossible";
        private static List<String> answerList;
        public String solution(int n, int m, int x, int y, int r, int c, int k) {
            x = x-1;//행
            y = y -1;//열
            R = r -1;//행
            C = c -1;//열
            K = k;
            maps = new int[n][m];
            //조기 종료
            int remainDis = Math.abs(x - R) + Math.abs(y - C);
            if(k < remainDis || (k - remainDis) % 2 !=0){
                return answer;
            }
            find(x, y, 0, "");



            return answer;
        }
        private static void find(int x, int y, int dept, String cmd){
            if (!answer.equals("impossible")) return;
            if(dept == K){
                if(x == R && y == C){
                    answer = cmd;
                }
                return;
            }
            int remainDis = Math.abs(x - R) + Math.abs(y - C);
            int remainMove = K - dept;
            if(remainDis > remainMove || (remainMove - remainDis) % 2 != 0 ){
                return;
            }
            for(int i = 0 ; i  < 4 ; i ++){
                int nextX = x+ dx[i];
                int nextY = y +dy[i];
                if(nextX >= 0 && nextY >= 0 && nextX < maps.length && nextY < maps[0].length){
                    String s = "";
                    if(i == 0){
                        s = "d";
                    }
                    else if(i == 1){
                        s = "l";
                    }
                    else if(i == 2){
                        s = "r";
                    }
                    else{
                        s = "u";
                    }
                    find(nextX, nextY, dept + 1, cmd + s);
                }
            }
        }
    }

}
