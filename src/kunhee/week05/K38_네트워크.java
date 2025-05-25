package kunhee.week05;

public class K38_네트워크 {

    public static int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers, visited);
                answer++; // 새 네트워크 발견
            }
        }

        return answer;
    }

    private static void dfs(int current, int[][] computers, boolean[] visited) {
        visited[current] = true;

        for (int i = 0; i < computers.length; i++) {
            if (!visited[i] && computers[current][i] == 1) {
                dfs(i, computers, visited);
            }
        }
    }

}
