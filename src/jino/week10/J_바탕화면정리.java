package jino.week10;

public class J_바탕화면정리 {
    class Solution {
        private static int maxUp;
        private static int maxLeft;
        private static int maxDown = 0;
        private static int maxRight = 0;
        private static int [][] intWallpaper;// # 은 1 . 은 0으로 저장할 예정
        private static int[] answer;
        public int[] solution(String[] wallpaper) {
            answer = new int[4];
            intWallpaper = new int[wallpaper.length][wallpaper[0].length()];
            maxUp = Integer.MAX_VALUE;
            maxLeft = Integer.MAX_VALUE;
            maxRight = Integer.MIN_VALUE;
            maxDown = Integer.MIN_VALUE;

            for(int i = 0 ; i < wallpaper.length ; i++){
                for(int j = 0 ; j < wallpaper[i].length() ;j++){
                    if(wallpaper[i].charAt(j) == '#'){
                        intWallpaper[i][j] = 1;
                    }
                    else{
                        intWallpaper[i][j] = 0;
                    }
                }
            }

            for(int i = 0 ; i < intWallpaper.length ; i++){
                for(int j = 0 ; j < intWallpaper[i].length ;j++){
                    if(intWallpaper[i][j] == 1){
                        maxUp = Math.min(i,maxUp);
                        maxDown = Math.max(i,maxDown);
                        maxLeft = Math.min(j,maxLeft);
                        maxRight = Math.max(j,maxRight);
                    }
                }
            }

            answer[0] = maxUp;
            answer[1] = maxLeft;
            answer[2] = maxDown + 1;
            answer[3] = maxRight + 1;
            return answer;
        }
    }
}
