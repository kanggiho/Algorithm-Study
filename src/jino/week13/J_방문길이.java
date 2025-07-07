package jino.week13;

import java.util.HashSet;
import java.util.Set;

public class J_방문길이 {

    class Solution {
        private static int[] dx = new int[]{-1, 0, 1, 0}; // 북, 동, 남, 서
        private static int[] dy = new int[]{0, 1, 0, -1}; // 북, 동, 남, 서
        private static int[][] maps;
        private static int x = 5;
        private static int y = 5;
        private static int answer = 0;
        private static Set<String> road;

        public int solution(String dirs) {
            maps = new int[11][11];
            road = new HashSet<>();
            for (int i = 0; i < dirs.length(); i++) {
                char c = dirs.charAt(i);
                find(i, c);
            }
            return answer = road.size() / 2;
        }

        private static void find(int i, char c) {
            int dir = 0;
            int nowX = x;
            int nowY = y;

            if (c == 'U') {
                dir = 0;
                x += dx[dir];
                y += dy[dir];
                if (x >= 0 && x < 11 && y >= 0 && y < 11) {
                    road.add(nowX +" "+ nowY + " " + x + " " + y);
                    road.add(x +" "+ y + " " + nowX + " " + nowY);

                }
                else {
                    x -= dx[dir];
                    y -= dy[dir];
                }
            } else if (c == 'R') {
                dir = 1;
                x += dx[dir];
                y += dy[dir];
                if (x >= 0 && x < 11 && y >= 0 && y < 11) {
                    road.add(nowX +" "+ nowY + " " + x + " " + y);
                    road.add(x +" "+ y + " " + nowX + " " + nowY);
                }

                else {
                    x -= dx[dir];
                    y -= dy[dir];
                }
            } else if (c == 'D') {
                dir = 2;
                x += dx[dir];
                y += dy[dir];
                if (x >= 0 && x < 11 && y >= 0 && y < 11) {
                    road.add(nowX +" "+ nowY + " " + x + " " + y);
                    road.add(x +" "+ y + " " + nowX + " " + nowY);

                } else {
                    x -= dx[dir];
                    y -= dy[dir];
                }
            } else { // 'L'
                dir = 3;
                x += dx[dir];
                y += dy[dir];
                if (x >= 0 && x < 11 && y >= 0 && y < 11) {
                    road.add(nowX +" "+ nowY + " " + x + " " + y);
                    road.add(x +" "+ y + " " + nowX + " " + nowY);

                } else {
                    x -= dx[dir];
                    y -= dy[dir];
                }
            }
        }
    }

}
