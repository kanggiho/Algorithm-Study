package heonwoo.week05;

public class H38_네트워크 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++){
            if (!visited[i]){
                dfs(i, computers, visited);
                answer++;
            }
        }

        return answer;
    }

    private void dfs(int current, int[][] computers, boolean[] visited){
        visited[current] = true;

        for (int i = 0; i < computers.length; i++){
            if (computers[current][i] == 1 && !visited[i]){
                dfs(i, computers, visited);
            }
        }
    }
}
