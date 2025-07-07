package jino.week13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class J_21오픈채팅방 {

    class Solution {
        private static Map<String, String> userMap;
        private static String[] answer;
        private static List<String> answerList;
        public String[] solution(String[] record) {

            userMap = new HashMap<>();
            for(String str : record){
                String[] strArr = str.split(" ");
                if(strArr[0].equals("Enter")){
                    userMap.put(strArr[1], strArr[2]);
                }
                else if(strArr[0].equals("Change")){
                    userMap.put(strArr[1], strArr[2]);
                }

            }
            answerList = new ArrayList<>();
            for(String str : record){
                String[] strArr = str.split(" ");
                if(strArr[0].equals("Enter")){
                    String name = userMap.get(strArr[1]);
                    answerList.add(name +"님이 들어왔습니다.");
                }
                else if(strArr[0].equals("Leave")){
                    String name = userMap.get(strArr[1]);
                    answerList.add(name +"님이 나갔습니다.");
                }
            }
            // answer = answerList.toArray(String[]::new);
            answer = new String [answerList.size()];
            for(int i = 0 ; i < answer.length ; i++){
                answer[i] = answerList.get(i);
            }
            return answer;
        }
    }
}
