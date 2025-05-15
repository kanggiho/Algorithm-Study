package jino.week6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class J40_딸배 {

    class Solution {
        private static int[] distance;
        private static int answer;
        private static PriorityQueue<Node> pq;
        private static List<Node>[] A;
        public int solution(int n, int[][] road, int K) {
            //초기화
            distance = new int[n+1];
            Arrays.fill(distance, Integer.MAX_VALUE);
            distance[1] = 0;

            pq = new PriorityQueue<>((o1, o2)->{
                return o1.value - o2.value;
            });

            A = new ArrayList[n+1];
            for(int i = 0 ; i < n+1 ; i++){
                A[i] = new ArrayList<>();
            }

            // 그래프 초기화 부분 수정
            for(int[] r : road) {
                int a = r[0];
                int b = r[1];
                int c = r[2];


                A[a].add(new Node(b, c));
                A[b].add(new Node(a, c));
            }

            //구현
            pq.add(new Node(1,0));
            while(!pq.isEmpty()){
                Node now = pq.poll();
                if(distance[now.next] < now.value) continue;
                for(Node next : A[now.next]){
                    if(distance[next.next] > now.value + next.value){
                        distance[next.next] = now.value + next.value;
                        pq.add(new Node(next.next , now.value + next.value));
                    }
                }
            }

            for(int i = 1 ; i < distance.length ; i++){
                if(distance[i] <= K) answer++;
            }



            return answer;
        }
        private static class Node{
            int next;
            int value;

            public Node(int next, int value){
                this.next = next;
                this.value = value;

            }
        }
    }


}
