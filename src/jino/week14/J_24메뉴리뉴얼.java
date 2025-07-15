package jino.week14;

import java.util.*;

public class J_24메뉴리뉴얼 {
  
    class Solution {
        private static String[]Orders;
        private static int[] Course;
        private static String[] answer;
        private static Map<String, Integer> comMap;
        public String[] solution(String[] orders, int[] course) {
            for(int i = 0 ; i < orders.length ; i++){
                String now = orders[i];
                char[]cArr = now.toCharArray();
                Arrays.sort(cArr);
                String temp = "";
                for(int j = 0 ; j < cArr.length ; j++){
                    temp += cArr[j];
                }
                orders[i] = temp;
            }
            Orders = orders;
            Course = course;
            comMap = new HashMap<>();
            ArrayList<String> answerList = new ArrayList<>();

            for(int i = 0 ; i < orders.length ; i++){
                String nowStr = orders[i];
                for(int j = 0 ; j < course.length ; j++){
                    int maxLen = course[j];
                    combination(nowStr, "", 0, 0, maxLen);
                }
            }

            for(int c : course){
                ArrayList<Com> comlist = new ArrayList<>();
                for(Map.Entry<String, Integer> et: comMap.entrySet()){
                    if(et.getKey().length() == c && et.getValue() >= 2) {
                        comlist.add(new Com(et.getKey(), et.getValue()));
                    }
                }
                if(comlist.size() > 0) {
                    Collections.sort(comlist,(o1,o2)->{
                        return o2.count - o1.count;
                    });
                    int maxCount = comlist.get(0).count;
                    answerList.add(comlist.get(0).combi);
                    for(int i = 1; i < comlist.size() ; i++){
                        if(maxCount == comlist.get(i).count){
                            answerList.add(comlist.get(i).combi);
                        }
                        else{
                            break;
                        }
                    }
                }
            }
            Collections.sort(answerList);
            answer = answerList.stream().toArray(String[] :: new);

            return answer;
        }
        private static void combination(String str, String nowStr, int start, int strLen, int maxLen){
            if(strLen == maxLen){
                comMap.put(nowStr, comMap.getOrDefault(nowStr, 0) + 1);
                return;
            }
            for(int i = start ; i < str.length() ; i++){
                combination(str, nowStr + str.charAt(i), i + 1, strLen + 1, maxLen);
            }
        }
        private static class Com{
            String combi;
            int count;
            public Com(String combi, int count){
                this.combi = combi;
                this.count = count;
            }
        }
    }

}
