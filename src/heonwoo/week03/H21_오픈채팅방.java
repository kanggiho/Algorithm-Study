package heonwoo.week03;

import java.util.Arrays;
import java.util.HashMap;

public class H21_오픈채팅방 {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234",
                "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        System.out.println(Arrays.toString(solution(record)));

    }

    private static String[] solution(String[] record) {
        HashMap<String, String> hashMap = new HashMap<>(); // (id - nickname) Map
        int cnt = 0;

        // 아이디와 닉네임간의 대응점을 찾아가는 과정
        for(int i = 0; i < record.length; i++) {
            String[] info = record[i].split(" ");

            if(info[0].equals("Leave")){     // 나가는 경우
                continue;
            } else if (info[0].equals("Enter")){  // 들어오는 경우
                hashMap.put(info[1], info[2]);
            } else {                               // 닉네임을 변경하는 경우
                hashMap.put(info[1], info[2]);
                cnt++;
            }
        }

        String[] result = new String[record.length - cnt];
        int idx = 0;

        for(int i = 0; i < record.length; i++) {
            String[] info = record[i].split(" ");
            String nickname = hashMap.get(info[1]); // 아이디에 대응되는 닉네임 반환

            if(info[0].equals("Enter")){
                result[idx++] = nickname + "님이 들어왔습니다.";
            } else if(info[0].equals("Leave")){
                result[idx++] = nickname + "님이 나갔습니다.";
            }
        }

        return result;
    }
}
