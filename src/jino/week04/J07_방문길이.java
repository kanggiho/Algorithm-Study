package jino.week04;

public class J07_방문길이 {
    class Solution {
        private static int[] dx = new int[]{0, -1, 0, 1};//행방향 이동 동 남 서 북
        private static int[] dy = new int[]{1, 0, -1, 0};//열방향 이동 동 남 서 북
        private static boolean[][][] check = new boolean[11][11][4];
        private static int X = 5;
        private static int Y = 5;
        private static int MaxX = 10;
        private static int MaxY = 10;
        private static int MinX = 0;
        private static int MinY = 0;
        private static int answer = 0;
        public int solution(String dirs) {
            for(int i = 0 ; i < dirs.length() ; i++){
                char c = dirs.charAt(i);
                int d = 0;
                if(c == 'R') d = 0;
                else if(c == 'D') d = 1;
                else if(c == 'L') d = 2;
                else if(c == 'U') d = 3;

                int nowX = X + dx[d];
                int nowY = Y + dy[d];

                if(nowX > MaxX || nowX < MinX || nowY > MaxY || nowY < MinY  ) continue;

                if(!check[X][Y][d] && !check[nowX][nowY][(d+2)%4]){
                    answer++; // 처음 방문하는 경로면 카운트 증가
                    check[X][Y][d] = true; // 현재 위치에서 d 방향 방문 표시
                    check[nowX][nowY][(d+2)%4] = true; // 다음 위치에서 반대 방향 방문 표시
                }

                // 위치 업데이트
                X = nowX;
                Y = nowY;
            }

            return answer;
        }
    }



}
