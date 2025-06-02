//package jino.week09;
//
//public class J_삼각달팽이 {
//    class Solution {
//        private static int total;
//        private static int[] answer;
//        private static int beforeT =0;
//        public int[] solution(int n) {
//            for(int i = 1 ; i <= n ; i++){
//                total += i;
//            }
//            for(int i = 1 ; i < n ; i++){
//                beforeT += i;
//            }
//
//
//            //System.out.println(total);
//            answer = new int[total];
//            int num = 1;
//            int j = 1;
//            for(int i = 0 ; i < total ;){
//                if(i < beforeT)
//                    answer[i] =  num;
//                num++;
//                i = i +j;
//                j = j + 1;
//
//
//            }
//            j = 0;
//            num = n;
//
//
//            return answer;
//        }
//    }
//}
