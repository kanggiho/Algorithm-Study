package giho.week04;

import java.util.*;



public class G40_배달 {

    class Node{
        int to;
        int weight;
        public Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    private static int[] dist;
    private static List<Node>[] graph;
    private static PriorityQueue<Node> pq;

    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        graph = new ArrayList[N+1];

        for(int i = 0 ; i < N+1 ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < road.length ; i++) {
            int from = road[i][0];
            int to = road[i][1];
            int weight = road[i][2];
            graph[from].add(new Node(to,weight));
            graph[to].add(new Node(from,weight));
        }

        dijkstra(1,N);


        for(int i = 0 ; i < dist.length ; i++){
            if(dist[i]<=K){
                answer++;
            }
        }

        return answer;
    }


    public void dijkstra(int start, int n){

        dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;
        pq = new PriorityQueue<>(Comparator.comparingInt(e->e.weight));

        pq.offer(new Node(start,0));


        while(!pq.isEmpty()){
            Node temp = pq.poll();
            int next = temp.to;

            if(temp.weight>dist[next]) continue;


            for(Node neighbor : graph[next]){
                if(dist[neighbor.to]>dist[next]+neighbor.weight){
                    dist[neighbor.to]=dist[next]+neighbor.weight;
                    pq.offer(new Node(neighbor.to,dist[neighbor.to]));
                }
            }
        }
    }
}
