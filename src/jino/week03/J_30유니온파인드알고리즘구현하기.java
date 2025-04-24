package jino.week03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class J_30유니온파인드알고리즘구현하기 {


    // The main method must be in a class named "Main".
    class Main {
        private static int[] parent;
        private static List<Boolean> answer;
        public static void main(String[] args) {
            System.out.println("Hello world!");
            boolean[] result = solution(3, new int[][]{{0,0,1},{0,1,2},{1,1,2}});
            System.out.println(Arrays.toString(result));
            // 추가 테스트 케이스 1: 더 많은 노드와 다양한 연산
            boolean[] result2 = solution(5, new int[][]{{0,0,1},{0,1,2},{0,3,4},{1,0,2},{1,3,4},{1,0,4}});
            System.out.println("테스트 케이스 2: " + Arrays.toString(result2));

            // 추가 테스트 케이스 2: 합집합 후 확인
            boolean[] result3 = solution(4, new int[][]{{0,0,1},{1,0,1},{0,2,3},{1,0,3},{1,1,3}});
            System.out.println("테스트 케이스 3: " + Arrays.toString(result3));

            // 추가 테스트 케이스 3: 복잡한 합집합 관계
            boolean[] result4 = solution(7, new int[][]{{0,0,1},{0,2,3},{0,4,5},{1,0,3},{1,1,5},{0,1,6},{1,0,6}});
            System.out.println("테스트 케이스 4: " + Arrays.toString(result4));

            // 추가 테스트 케이스 4: 순환 구조 테스트
            boolean[] result5 = solution(6, new int[][]{{0,0,1},{0,1,2},{0,2,3},{0,3,4},{0,4,5},{0,5,0},{1,0,3},{1,1,4},{1,2,5}});
            System.out.println("테스트 케이스 5: " + Arrays.toString(result5));
        }




        public static boolean[] solution(int k , int[][] operations) {
            parent = new int[k];
            answer = new ArrayList<>();
            for(int i = 0 ; i < k ;i++){
                parent[i] = i;
            }

            for(int i = 0 ; i < operations.length ; i++){
                if(operations[i][0] == 0){
                    union(operations[i][1] ,operations[i][2]);
                }
                else{
                    check(operations[i][1] ,operations[i][2]);
                }
            }
            boolean[] answers = new boolean[answer.size()];
            for (int i = 0; i < answer.size(); i++) {
                answers[i] = answer.get(i);
            }

            return answers;
        }


        private static void union(int a, int b){
            a = find(parent[a]);
            b = find(parent[b]);

            if( a != b){
                parent[b] = a;
            }

        }

        private static int find(int a){
            if(a == parent[a]){
                return a;
            }
            return parent[a] = find(parent[a]);
        }

        private static void check(int a, int b){
            if(find(a) == find(b)){
                answer.add(true);
            }
            else{
                answer.add(false);
            }
        }
    }
}
