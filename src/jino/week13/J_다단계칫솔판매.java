package jino.week13;

import java.util.HashMap;
import java.util.Map;

public class J_다단계칫솔판매 {

    class Solution {
        private static Map<String, String> parent;
        private static Map<String, Integer> peopelMoney;

        public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
            parent = new HashMap<>();
            peopelMoney = new HashMap<>();

            for(int i = 0; i < enroll.length; i++){
                parent.put(enroll[i], referral[i]);
                peopelMoney.put(enroll[i], 0);
            }

            for(int i = 0; i < seller.length; i++){
                int money = amount[i] * 100;
                String people = seller[i];
                while(!people.equals("-") && money > 0){
                    int give = money / 10;
                    int keep = money - give;
                    peopelMoney.put(people, peopelMoney.getOrDefault(people, 0) + keep);
                    money = give;
                    people = parent.get(people);
                }
            }


            int[] answer = new int[enroll.length];
            for (int i = 0; i < enroll.length; i++) {
                answer[i] = peopelMoney.getOrDefault(enroll[i], 0);
            }

            return answer;
        }
    }

}
