package giho.week05;

public class G45_피로도 {

    public static int[][] dungeon;
    public static boolean[] visited;
    public static int answer;

    public int solution(int k, int[][] dungeons) {

        dungeon = dungeons;
        visited = new boolean[dungeons.length];
        backtrack(k,0);
        return answer;
    }

    public void backtrack(int fatigue, int count){
        answer = Math.max(answer,count);

        for(int i = 0 ; i < dungeon.length;i++){

            int minFatigue = dungeon[i][0];
            int useFatigue = dungeon[i][1];

            if(fatigue>=minFatigue){
                if(!visited[i]){
                    visited[i]=true;
                    backtrack(fatigue-useFatigue,count+1);
                    visited[i]=false;
                }
            }
        }
    }

}
