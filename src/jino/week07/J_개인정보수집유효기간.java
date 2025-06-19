package jino.week07;

import java.util.*;
public class J_개인정보수집유효기간 {

    class Solution {
        private static int[] Pprivacies;
        private static List<Integer> answerList;
        private static int[] answer;
        private static Map<String, Integer> deadMap;

        public int[] solution(String today, String[] terms, String[] privacies) {
            //초기화
            Pprivacies = new int[privacies.length];
            answerList = new ArrayList<>();
            deadMap = new HashMap<>();

            int Today = changeDay(today);

            for(String term : terms){
                String[] termParts = term.split(" ");
                String termType = termParts[0];
                int validMonths = Integer.parseInt(termParts[1]);
                deadMap.put(termType, validMonths * 28);
            }
            for(int i = 0 ; i < Pprivacies.length ; i++){
                String date = privacies[i].substring(0,10);
                int day = changeDay(date);

                String[] privacyParts = privacies[i].split(" ");
                String termType = privacyParts[1];
                int plusDay = deadMap.get(termType);

                day += plusDay;
                if(Today >= day ){
                    answerList.add(i+1);
                }


            }
            answer = answerList.stream()
                    .mapToInt(x -> x)
                    .toArray();
            return answer;
        }

        private static int changeDay(String date){
            String[] parts = date.split("\\.");
            int year = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int day = Integer.parseInt(parts[2]);

            return (year * 12 * 28) + (month * 28) + day;

        }

    }
}
