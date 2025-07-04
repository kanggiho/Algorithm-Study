package jino.week13;

import java.util.*;

public class J_미로탈출명령어 {


    class Solution {
        private static int[][] maps;
        private static String answer = "";
        private static int R;
        private static int C;
        private static int K;
        private static int[] dx = new int[] {1, 0, 0, -1};//남 서 동 북
        private static int[] dy = new int[] {0, -1, 1, 0};//남 서 동 북
        private static Deque<Cmd> dq;
        private static List<String> answerList;

        public String solution(int n, int m, int x, int y, int r, int c, int k) {
            maps = new int[n][m];
            R = r;
            C = c;
            K = k;
            dq = new ArrayDeque<>();
            answerList = new ArrayList<>();
            BFS(x, y,0, "");


            if(answerList.isEmpty()) {
                return "impossible";
            }

            Collections.sort(answerList, Collections.reverseOrder());
            answer = answerList.get(0);
            char[] cArr = answer.toCharArray();
            answer = "";
            for(int i = 0 ; i < cArr.length ; i++){
                if(cArr[i] == '0'){
                    answer += "d";
                }
                else if(cArr[i] == '1'){
                    answer += "l";
                }
                else if(cArr[i] == '2'){
                    answer += "r";
                }
                else{
                    answer += "u";
                }
            }
            return answer;
        }
        private static void BFS(int x, int y,int count, String dic){
            dq.add(new Cmd(x, y, count,dic));
            while(!dq.isEmpty()){

                while(!dq.isEmpty() && dq.peek().dic.length() > K){
                    dq.poll();
                }


                if(dq.isEmpty()) {
                    break;
                }

                Cmd now = dq.poll();
                x = now.x;
                y = now.y;
                count = now.count;
                dic = now.dic;

                for(int i = 0 ; i < 4 ; i++){
                    int nextX = x + dx[i];
                    int nextY = y + dy[i];
                    if(nextX >= 0 && nextY >= 0 && nextX < maps.length
                            && nextY < maps[0].length ){
                        if(nextX == R && nextY == C && count +1 == K){
                            answerList.add(dic + i);
                        }
                        else{
                            dq.add(new Cmd (nextX, nextY, count+1, dic + i));
                        }

                    }
                }
            }
        }
        private static class Cmd{
            int x;
            int y;
            int count;
            String dic;

            public Cmd(int x, int y, int count, String dic){
                this.x = x;
                this.y = y;
                this.count = count;
                this.dic = dic;
            }
        }

    }

}
