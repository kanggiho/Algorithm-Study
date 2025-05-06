package jino.week04;

import java.util.Arrays;

public class J33_섬연결하기 {

    class Solution {
        private static int[] parent;
        private static int count = 0;
        public int solution(int n, int[][] costs) {
            int answer = 0;
            parent = new int[n];
            for(int i = 0 ; i < n ;i++){
                parent[i] = i;
            }

            Arrays.sort(costs,(o1, o2)->{
                return o1[2] - o2[2];
            });
            for(int[] arr : costs){
                if(count == n-1) break;
                if(find(arr[0]) != find(arr[1])){
                    union(arr[0] ,arr[1]);
                    answer += arr[2];
                    count++;
                }
            }

            return answer;
        }


        private static void union(int a, int b){
            a = find(a);
            b = find(b);
            if(a != b){
                parent[b] = a;
            }
        }
        private static int find(int a){
            if(a == parent[a]){
                return a;
            }
            return parent[a] = find(parent[a]);
        }
    }
}
