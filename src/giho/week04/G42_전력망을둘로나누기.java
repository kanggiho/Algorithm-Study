package giho.week04;

import java.util.*;

public class G42_전력망을둘로나누기 {
    static boolean[] visited;
    static List<Integer>[] graph;
    static int count;

    public int solution(int n, int[][] wires) {

        int answer = Integer.MAX_VALUE;

        for(int i = 0 ; i < wires.length ; i++){

            visited = new boolean[n + 1];
            graph = new ArrayList[n + 1];
            count = 0;
            int exist = -1;

            for(int j = 0 ; j < graph.length ; j++){
                graph[j] = new ArrayList<>();
            }

            for(int j = 0 ; j < wires.length ; j++){
                if(i==j)continue;

                int from = wires[j][0];
                int to = wires[j][1];

                graph[from].add(to);
                graph[to].add(from);
                exist = from;
            }
            dfs(exist);
            answer = Math.min(answer, Math.abs(n-2*count));
        }
        return answer;
    }

    public void dfs(int temp){

        visited[temp] = true;
        count++;
        for(int next : graph[temp]){
            if(!visited[next]){
                dfs(next);
            }
        }
    }
}
