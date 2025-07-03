package jino.week13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class J_개인정보수집유효기간 {
    class Solution {
        private static Map<String, Integer> termsMap;
        private static int[] answer;
        private static List<Integer> answerList;
        private static int[] Privacies;
        public int[] solution(String today, String[] terms, String[] privacies) {
            termsMap = new HashMap<>();
            for(int i = 0 ; i < terms.length ; i++){
                String[] sArr = terms[i].split(" ");
                termsMap.put(sArr[0], Integer.parseInt(sArr[1]) * 28);
            }
            answerList = new ArrayList<>();
            Privacies = new int[privacies.length];
            for(int i = 0 ; i < Privacies.length ; i++){
                String[] sArr = privacies[i].split(" ");
                int date = changeDay(sArr[0]);
                int plus = termsMap.get(sArr[1]);
                Privacies[i] = date + plus;
            }
            int Today = changeDay(today);
            for(int i = 0 ; i < Privacies.length ; i++){
                if(Today >= Privacies[i]){
                    answerList.add(i + 1);
                }
            }
            answer = answerList.stream()
                    .mapToInt(i -> i)
                    .toArray();



            return answer;
        }
        private static int changeDay(String now){
            String[] arr = now.split("\\.");
            int year = Integer.parseInt(arr[0]);
            int month = Integer.parseInt(arr[1]);
            int day = Integer.parseInt(arr[2]);
            int sum = day + (month * 28) + (year * 12 * 28);
            return sum;
        }
    }
}
