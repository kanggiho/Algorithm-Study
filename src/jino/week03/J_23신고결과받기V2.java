package jino.week03;

import java.util.*;

public class J_23신고결과받기V2 {

    class Solution {
        private static Map<String ,Integer> reportCount; // k번 이상신고당한 횟수 저장
        private static Map<String ,ArrayList<String>>reportPepole; // 내가 누굴 신고했는지 저장
        public int[] solution(String[] id_list, String[] report, int k) {
            int[] answer = new int[id_list.length];
            Set<String> mySet = new HashSet<>();

            for(String str: report){
                mySet.add(str);
            }
            //Set <String> mySet = new HashSet<>(Arrays.asList(report));

            reportCount = new HashMap<>();
            reportPepole = new HashMap<>();

            //k 번 이상 신고당한 사람 구하기
            for(String str : mySet){
                String[] arr = str.split(" ");
                String reporter = arr[0];
                String target = arr[1];

                if(!reportPepole.containsKey(reporter)){
                    reportPepole.put(reporter, new ArrayList<>());
                }
                reportPepole.get(reporter).add(target);

                reportCount.put(target , reportCount.getOrDefault(target,0)+1);
            }

            for(int i = 0 ; i < id_list.length ; i++){
                String name = id_list[i];
                if(reportPepole.containsKey(name))
                    for(String str:reportPepole.get(name)){
                        if(reportCount.getOrDefault(str,0) >= k) {
                            answer[i]++;
                        }
                    }
            }



            return answer;
        }
    }

}
