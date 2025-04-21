package jino.week03;

import java.util.HashMap;
import java.util.Map;

public class j_27다단계 {
    
    class Solution {
        public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
            Map <String, String> parent = new HashMap<>();

            for(int i = 0 ; i < enroll.length ;i++){
                parent.put(enroll[i], referral[i]);
            }

            // for(Map.Entry<String, String> et : parent.entrySet()){
            //     String key =et.getKey();
            //     System.out.println(key +" "+ et.getValue());
            // }

            Map<String, Integer> total = new HashMap<>();

            for(int i = 0 ; i < seller.length ;i++){
                String name = seller[i];
                int price = amount[i] * 100 ;

                while(!name.equals("-")  && price > 0){
                    total.put(name, total.getOrDefault(name,0) + price -(price /10));
                    name = parent.get(name);
                    price = (price /10);
                }
            }




            int[] answer = new int [enroll.length];
            for(int i = 0 ; i < answer.length ;i++){
                answer[i] = total.getOrDefault(enroll[i],0);
            }
            return answer;
        }
    }
}
