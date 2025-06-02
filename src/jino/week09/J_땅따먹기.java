//package jino.week09;
//
//public class J_땅따먹기 {
//    class Solution {
//        private static int answer = 0;
//        private static int[][] Land;
//        private static boolean[] visited;
//        int solution(int[][] land) {
//            //초기화
//            Land = land;
//            visited = new boolean [land[0].length];
//            ground(0, 0, 0);
//            System.out.println("Hello Java");
//
//            return answer;
//        }
//        private static void ground(int col,int dept, int count){
//            if(dept == Land.length){
//                return;
//            }
//            for(int i = 0 ; i < Land[dept].length ; i++){
//                if(!visited[i]){
//                    if(dept > 0){
//                        visited[col] = false;
//                    }
//                    count += Land[dept][i];
//                    visited[i] = true;
//                    dept++;
//                    answer = Math.max(count, answer);
//                    ground(i ,dept, count);
//                    visited[i] = false;
//                    dept--;
//                    count -= Land[dept][i];
//                }
//            }
//        }
//    }
//}
