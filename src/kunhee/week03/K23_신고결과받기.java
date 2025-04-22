package kunhee.week03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class K23_신고결과받기 {

    public static int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reportMap = new HashMap<>(); // 신고당한ID, 신고한ID들
        Map<String, Integer> mailCount = new HashMap<>();     // 유저별 메일 카운트

        // 모든 id에 대한 mail count 초기화
        for (String id : id_list) {
            mailCount.put(id, 0);
        }

        // 신고 정보 누적
        for (String r : report) {
            String[] parts = r.split(" ");
            String from = parts[0]; // 신고자
            String to = parts[1];   // 피신고자

            reportMap.putIfAbsent(to, new HashSet<>());
            reportMap.get(to).add(from);
        }

        // 정지 대상 확인 및 메일 카운트 증가
        for (String reported : reportMap.keySet()) {
            Set<String> reporters = reportMap.get(reported);
            if (reporters.size() >= k) {
                for (String reporter : reporters) {
                    mailCount.put(reporter, mailCount.get(reporter) + 1);
                }
            }
        }

        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = mailCount.get(id_list[i]);
        }

        return answer;
    }

}
