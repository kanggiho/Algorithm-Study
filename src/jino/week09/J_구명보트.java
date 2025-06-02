//package jino.week09;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class J_구명보트 {
//
//
//    class Solution {
//        private static int boat = 0;
//        private static List<Integer> peopleList;
//        public int solution(int[] people, int limit) {
//            peopleList =  Arrays.stream(people)
//                    .boxed()
//                    .collect(Collectors.toList());
//            Collections.sort(peopleList, Collections.reverseOrder());
//            // System.out.println(peopleList);
//
//            List<Integer> pigList = new ArrayList<>();
//            for(int i = 0 ; i < peopleList.size() ;i++){
//                if(limit - peopleList.get(i) < 40){
//                    pigList.add(peopleList.get(i));
//
//                }
//            }
//            int end = pigList.size() -1;//맨앞
//            int start = peopleList.size() -1;//맨뒤
//            int sum = 0;
//            for(int i = start ; i > end ; i--){
//                sum += peopleList.get(i);
//                if(sum > limit){
//                    i++;
//                    sum = 0;
//                    boat++;
//                }
//
//
//            }
//
//
//
//            System.out.println(pigList);
//            boat += pigList.size();
//
//
//            return boat;
//        }
//    }
//}
