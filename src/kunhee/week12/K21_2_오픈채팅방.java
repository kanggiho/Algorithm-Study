package kunhee.week12;

// https://school.programmers.co.kr/learn/courses/30/lessons/42888

import java.util.*;

public class K21_2_오픈채팅방 {

    public static String[] solution(String[] record) {
        List<String> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();

        for (String s : record) {
            String[] arr = s.split(" ");
            if (arr[0].equals("Enter") || arr[0].equals("Change")){
                map.put(arr[1], arr[2]);
            }
        }

        for (String s : record) {
            String[] arr = s.split(" ");
            if (arr[0].equals("Enter")) {
                list.add(String.format("%s님이 들어왔습니다.", map.get(arr[1])));
            } else if (arr[0].equals("Leave")) {
                list.add(String.format("%s님이 나갔습니다.", map.get(arr[1])));
            }
        }

        return list.toArray(new String[0]);
    }

    public static void main(String[] args) {
        // 테스트 케이스 1
        String[] record1 = {
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
        };
        String[] result1 = solution(record1);
        System.out.println(Arrays.toString(result1));
        // 예상 출력:
        // ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.",
        //  "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]
    }
}
