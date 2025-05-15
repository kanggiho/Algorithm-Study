package jino.week6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class J36_다익스트라알고리즘 {


    // The main method must be in a class named "Main".
    class Main {
        private static List<Node>[] A;
        private static int[] distance;
        private static int[] answer;
        private static PriorityQueue<Node> pq;

        public static void main(String[] args) {
            System.out.println(Arrays.toString(solution(new int[][]{{0, 1, 9}, {0, 2, 3}, {1, 0 ,5}, {2, 1, 1}}, 0 ,3)));
            System.out.println(Arrays.toString(solution(new int[][]{{0, 1, 1}, {1, 2, 5}, {2, 3 ,1}}, 0 ,4)));
        }

        private static int[] solution(int[][] graph, int start , int n){
            //초기화
            A = new ArrayList[n];
            answer = new int[n];
            for(int i = 0 ; i < n ; i++){
                A[i] = new ArrayList<>();
            }

            for(int[] edge : graph){
                A[edge[0]].add(new Node(edge[1], edge[2]));
            }

            distance = new int[n];
            Arrays.fill(distance, Integer.MAX_VALUE);
            distance[start] = 0;

            pq = new PriorityQueue<>((o1, o2) ->{
                return o1.value - o2.value;
            });

            pq.add(new Node(start, 0));

            while(!pq.isEmpty()){
                Node now = pq.poll();

                if(distance[now.end] < now.value) continue;

                for(Node next : A[now.end]){
                    if(distance[next.end] > now.value + next.value){
                        distance[next.end] = now.value + next.value;
                        pq.add(new Node(next.end, distance[next.end]));
                    }
                }
            }
            return distance;

        }
        private static class Node{
            int end;
            int value;

            public Node(int end, int value){
                this.end = end;
                this.value = value;
            }
        }
    }
}
