package giho.others;

import java.util.*;

public class park {


    class Solution {
        public int[] solution(String[] park, String[] routes) {
            int n = park.length;
            int m = park[0].length();

            int[] temp = new int[2];


            int[][] map = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (park[i].charAt(j) == 'S') {
                        temp[0] = i;
                        temp[1] = j;
                        map[i][j] = 0;
                    } else if (park[i].charAt(j) == 'O') {
                        map[i][j] = 0;
                    } else if (park[i].charAt(j) == 'X') {
                        map[i][j] = 1;
                    }
                }
            }


            for (int i = 0; i < routes.length; i++) {
                char target = routes[i].charAt(0);
                int weight = Integer.parseInt(routes[i].substring(2));

                int newY = temp[0];
                int newX = temp[1];

                boolean valid = true;

                for (int j = 0; j < weight; j++) {
                    if (target == 'N') newY--;
                    else if (target == 'S') newY++;
                    else if (target == 'W') newX--;
                    else if (target == 'E') newX++;

                    if (newY < 0 || newY >= n || newX < 0 || newX >= m || map[newY][newX] == 1) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    temp[0] = newY;
                    temp[1] = newX;
                }
            }

            return temp;
        }
    }
}
