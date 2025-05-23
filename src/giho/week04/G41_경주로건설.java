package giho.week04;

import java.util.*;


public class G41_경주로건설 {
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,1,-1};

    public static boolean[][] visited;
    public static int[][] boards;
    public static int n;
    public static List<Integer> path;
    public static List<List<Integer>> allPath;



    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;

        n = board.length;
        visited = new boolean[n][n];
        path = new ArrayList<>();
        allPath = new ArrayList<>();
        boards = board;


        dfs(0,0,n-1,n-1);


        for(int i = 0 ; i <allPath.size(); i++){
            int count = 0;
            int temp = allPath.get(i).get(0);
            for(int j = 0 ; j < allPath.get(i).size()-1; j++){
                if(temp!=allPath.get(i).get(j+1)){
                    count++;
                }
                temp = allPath.get(i).get(j+1);
            }

            answer = Math.min(answer,allPath.get(i).size()*100+count*500);
        }


        return answer;
    }


    public void dfs(int x, int y, int targetX, int targetY){
        if(targetX == x && targetY == y){
            allPath.add(new ArrayList<>(path));
            return;
        }

        visited[y][x] = true;

        for (int i = 0; i < 4 ; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX >=n|| newY >=n || newX<0 || newY<0){
                continue;
            }
            if(boards[newY][newX]==1||visited[newY][newX]){
                continue;
            }
            path.add(i);
            dfs(newX,newY,targetX,targetY);
            path.remove(path.size()-1);
        }

        visited[y][x] = false;

    }
}
