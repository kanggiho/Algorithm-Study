//package jino.week07;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class J_개인정보수집유효기간 {
//
//    class Solution {
//        private Map<String , Integer> myHash;
//        private int[] answer;
//        private List<Integer> answerList;
//        private String[] todayArr;
//        public int[] solution(String today, String[] terms, String[] privacies) {
//            //초기화
//            myHash = new HashMap<>();
//            answerList = new ArrayList<>();
//            todayArr = today.split("\\.");
//            for(int i = 0 ; i < terms.length ; i++){
//                String a = terms[i].charAt(0)+"";
//                int b = (int)(terms[i].charAt(1));
//                myHash.put(a, b);
//            }
//            for(int i = 0 ; i < privacies.length ; i++){
//                String[] privaciesArr = privacies[i].split("\\.");
//                String[] temp = privaciesArr[2].split(" ");
//                privaciesArr[2] = temp[0];
//                String B = temp[1];
//                // System.out.println(B);
//
//                addDay(i+1, privacies[i], B);
//            }
//
//
//            return answer;
//        }
//        private static void addDay(int index , String[] privaciesArr, String A){//날짜 변환기
//            int plusMounth =  myHash.get(A);
//            String mounth = privaciesArr[1];
//            int mounth = Integer.parseInt(mounth);
//            int now = plusMounth + mounth -1;
//            if(now > 12){
//                now = now % 12;
//                privaciesArr[0] = Integer.parseInt(privaciesArr[0] + 1)+"";
//            }
//            privaciesArr[1] = now+"";
//            privaciesArr[0] = (Integer.parseInt(privaciesArr[0]) - 1) +"";
//            if(privaciesArr[2].equals("0")){
//                privaciesArr[2] = "28";
//            }
//
//
//
//        }
//    }
//}
