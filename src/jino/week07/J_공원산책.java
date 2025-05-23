package jino.week07;

public class J_공원산책 {
    class Solution {
        private static int[] answer;
        private static char[][] maps;
        public int[] solution(String[] park, String[] routes) {
            //초기화
            answer = new int[2];
            int startX = 0;
            int startY = 0;
            int endX = park.length;
            int endY = park.length;
            maps = new char[park.length][park.length];
            for(int i  = 0 ; i < park.length ; i++){
                for(int j = 0 ; j < park.length ; j++){
                    maps[i][j] = park[i].charAt(j);
                    if(maps[i][j] == 'S'){
                        startX = i;
                        startY = j;
                    }
                }
            }

            for(int test = 0 ; test < routes.length ; test++ ){
                String[] route = routes[test].split(" ");
                char way = route[0].charAt(0);
                int val = Integer.parseInt(route[1]);
                if(way == 'N'){//북
                    for(int i = 0 ; i < val ;i++){
                        startX--;
                        if(startX < 0 && startX >= endX ){
                            break;
                        }

                        if(maps[startX][startY] =='X'){
                            startX++;
                        }
                    }
                }
                else if(way == 'S'){//남
                    for(int i = 0 ; i < val ;i++){
                        startX++;
                        if(startX < 0  && startX >= endX ){
                            break;
                        }

                        if(maps[startX][startY] =='X'){
                            startX--;
                        }
                    }

                }
                else if(way == 'W'){//서
                    for(int i = 0 ; i < val ;i++){
                        startY--;
                        if(startY < 0 && startY >= endY ){
                            break;
                        }

                        if(maps[startX][startY] =='X'){
                            startY++;
                        }
                    }
                }
                else {//동
                    for(int i = 0 ; i < val ;i++){
                        startY++;
                        if(startY < 0 && startY >= endY ){
                            break;
                        }

                        if(maps[startX][startY] =='X'){
                            startY--;
                        }

                    }
                }

            }
            answer[0] = startX;
            answer[1] = startY;
            return answer;
        }
    }
}
