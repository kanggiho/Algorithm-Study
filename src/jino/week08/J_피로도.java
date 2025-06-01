package jino.week08;

public class J_피로도 {
    class Solution {
        private static int answer = 0;
        private static boolean[] visited;
        private static int[][] dungeon;
        public int solution(int k, int[][] dungeons) {
            dungeon = dungeons;
            visited = new boolean [dungeons.length];
            playGame(0, k);
            return answer;
        }
        private static void playGame(int stageCount,int health){
            for(int i = 0 ; i < dungeon.length ;i++){
                if(dungeon[i][0] <= health && !visited[i]){
                    visited[i] = true;
                    playGame(stageCount + 1, health -dungeon[i][1]);
                    answer = Math.max(stageCount + 1, answer);
                    visited[i] = false;

                }
            }


        }

    }
}
