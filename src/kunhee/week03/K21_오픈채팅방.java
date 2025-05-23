package kunhee.week03;

import java.util.*;

public class K21_오픈채팅방 {

    public static String[] solution(String[] record) {
        Map<String, String> userMap = new HashMap<>(); // uid에 대한 최신 닉네임 저장
        List<String[]> logs = new ArrayList<>();       // [action, uid] 저장

        for (String r : record) {
            String[] parts = r.split(" ");
            String action = parts[0];
            String uid = parts[1];

            // 닉네임이 포함된 명령이면 닉네임 업데이트
            if (action.equals("Enter") || action.equals("Change")) {
                String nickname = parts[2];
                userMap.put(uid, nickname);
            }

            // 메시지를 출력할 명령만 기록
            if (action.equals("Enter") || action.equals("Leave")) {
                logs.add(new String[]{uid, action});
            }
        }

        // 출력 메시지 만들기
        String[] result = new String[logs.size()];
        for (int i = 0; i < logs.size(); i++) {  // + 여기서 action을 정리하는 것도 좋을 것 같음
            String uid = logs.get(i)[0];
            String action = logs.get(i)[1];
            String nickname = userMap.get(uid);

            if (action.equals("Enter")) {
                result[i] = nickname + "님이 들어왔습니다.";
            } else {
                result[i] = nickname + "님이 나갔습니다.";
            }
        }

        return result;
    }

}
