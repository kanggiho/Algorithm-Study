package giho.week04;

public class G38_네트워크 {

    private static int[][] computer;
    private static boolean[] visited;

    private static void dfs(int now){
        if(!visited[now]){
            visited[now] = true;
            for(int i = 0 ; i < computer[now].length ; i++){
                if(computer[now][i]==1&&!visited[i])
                    dfs(i);
            }
        }
    }


    public int solution(int n, int[][] computers) {
        int answer = 0;
        computer=computers;
        visited = new boolean[n];

        for(int i = 0; i < n ; i++){
            if(!visited[i]){
                dfs(i);
                answer++;
            }
        }

        return answer;
    }
}
