package giho.week04;

import java.util.Arrays;

public class G33_섬연결하기 {


    public int find(int x, int[] parent) {
        if (parent[x] == x) {
            return x;
        }
        return find(parent[x], parent);
    }

    public void union(int x, int y, int[] parent) {
        int p1 = find(x, parent);
        int p2 = find(y, parent);
        parent[p2] = p1;
    }


    public int solution(int n, int[][] costs) {
        int answer = 0;
        int edges = 0;
        int[] parent = new int[n];

        Arrays.sort(costs, ((o1, o2) -> Integer.compare(o1[2], o2[2])));

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < costs.length; i++) {
            if(edges == n-1){
                break;
            }

            if(find(costs[i][0],parent)!=find(costs[i][1],parent)){
                union(costs[i][0],costs[i][1],parent);
                answer+=costs[i][2];
                edges++;
            }
        }

        return answer;
    }
}
