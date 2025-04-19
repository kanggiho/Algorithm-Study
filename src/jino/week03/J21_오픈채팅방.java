package jino.week03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class J21_오픈채팅방 {

    class Solution {
        static Map<String, String> hash;
        static List<String> IdList;//uid1234
        static List<String> visitList;//들어왔습니다 나갔습니다.

        public String[] solution(String[] record) {
            hash = new HashMap<>();
            IdList = new ArrayList<>();
            visitList = new ArrayList<>();
            List<String> nameList = new ArrayList<>();

            for (String str : record) {
                check(str);
            }
            // System.out.println(list.toString());
            for (int i = 0; i < IdList.size(); i++) {
                nameList.add(hash.get(IdList.get(i)));
            }
            // System.out.println(nameList.toString());

            String[] answer = new String[nameList.size()];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = nameList.get(i) + visitList.get(i);
            }

            return answer;
        }


        private static void check(String str) {
            String[] arr = str.split(" ");
            // System.out.println(arr[0]);
            switch (arr[0]) {
                case "Enter":
                    hash.put(arr[1], arr[2]);
                    IdList.add(arr[1]);
                    visitList.add("님이 들어왔습니다.");
                    break;

                case "Leave":
                    IdList.add(arr[1]);
                    visitList.add("님이 나갔습니다.");
                    break;

                case "Change":
                    hash.put(arr[1], arr[2]);
                    break;
            }

        }
    }
}
