package kunhee.week02;

import java.util.HashMap;
import java.util.Map;

public class K19_완주하지못한선수 {

    public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        // 참가자 명단 - 카운트 증가
        for (String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        // 완주자 명단 - 카운트 감소
        for (String name : completion) {
            map.put(name, map.get(name) - 1);
        }

        // 완주 못한 사람 찾기
        for (String name : map.keySet()) {
            if (map.get(name) != 0) {
                return name;
            }
        }

        return "";
    }

}
