package jino.week03;

import java.util.*;

public class J23_신고결과받기 {

    class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            int[] answer = new int[id_list.length];
            Set<String> reportSet = new HashSet<>();
            for(String str : report){
                reportSet.add(str);
            }

            Map<String, List<String> > hash = new HashMap<>();

            for(String str : reportSet){
                String[] sArr = str.split(" ");
                if(!hash.containsKey(sArr[0])){
                    hash.put(sArr[0],new ArrayList<>());
                }
                hash.get(sArr[0]).add(sArr[1]);
            }
            // for(Map.Entry<String, List<String> > entry: hash.entrySet() ){
            //    String key = entry.getKey();
            //     List<String> values = entry.getValue();
            //     System.out.println("키: " + key);
            //     for(String str :values){
            //         System.out.println(str);
            //     }
            // }

            Map<String, Integer> countHash = new HashMap<>();
            for(Map.Entry<String, List<String> > entry: hash.entrySet() ){
                String key = entry.getKey();
                List<String> values = entry.getValue();
                for(String str :values){
                    countHash.put(str, countHash.getOrDefault(str,0)+1);
                }
            }


            countHash.entrySet().removeIf(entry -> entry.getValue() < k);

            for(Map.Entry<String, Integer> entry: countHash.entrySet()){
                String key = entry.getKey();
                System.out.println(key +"," + entry.getValue());
            }

            for(int i = 0; i < id_list.length; i++) {
                String userId = id_list[i];

                if(hash.containsKey(userId)) {
                    List<String> reportedUsers = hash.get(userId);

                    for(String reportedUser : reportedUsers) {
                        if(countHash.containsKey(reportedUser)) {
                            answer[i]++;
                        }
                    }
                }
            }





            return answer;
        }
    }
}
