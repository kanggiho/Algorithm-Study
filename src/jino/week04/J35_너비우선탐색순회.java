package jino.week04;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class J35_너비우선탐색순회 {

    // The main method must be in a class named "Main".
    class Main {
        private static boolean visited[];
        private static ArrayList<Integer>[] A;
        private static Deque<Integer> myQue;
        private static ArrayList<Integer> answerList;
        public static void main(String[] args) {
            System.out.println(Arrays.toString(solution(new int[][]{ {1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {4, 8}, {5, 8}, {6, 9},{7, 9} }, 1 , 9)));
            System.out.println(Arrays.toString(solution(new int[][]{ {1, 3}, {3, 4}, {3, 5}, {5, 2} }, 1, 6)));
        }//main

        private static int[] solution(int[][] graph, int start ,int node){
            //초기화
            visited = new boolean[node+1];
            A = new ArrayList[node+1];
            myQue = new ArrayDeque<>();
            answerList = new ArrayList<>();

            for(int i = 1 ; i < node+1 ; i++){
                A[i] = new ArrayList<>();
            }
            for(int i = 0 ; i < graph.length ; i++){
                A[graph[i][0]].add(graph[i][1]);
                A[graph[i][1]].add(graph[i][0]);
            }
            BFS(start);
            int[] answer = answerList.stream()
                    .mapToInt(i -> i)
                    .toArray();
            return answer;



        }//sol
        private static void BFS(int start){
            myQue.add(start);
            visited[start] = true;
            while(!myQue.isEmpty()){
                int now =myQue.poll();

                answerList.add(now);

                for(int i :A[now]){
                    if(!visited[i]){
                        myQue.add(i);
                        visited[i] = true;
                    }

                }
            }
        }


    }//Main

}
