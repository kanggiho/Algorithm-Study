package giho.week03;

import java.util.*;

public class G23_신고결과받기 {

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String,Integer> idIndex = new HashMap<>();
        Map<String, Set<String>> reportRelation = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            idIndex.put(id_list[i], i);
        }

        for(String rep : new HashSet<>(Arrays.asList(report))){
            String[] ids = rep.split(" ");

            String reportId = ids[0];
            String reportedId = ids[1];

            reportRelation.putIfAbsent(reportedId, new HashSet<>());
            reportRelation.get(reportedId).add(reportId);
        }

        for(String reported : reportRelation.keySet()){
            Set<String> reportSet = reportRelation.get(reported);
            if(reportSet.size() >= k){
                for(String reporter : reportSet){
                   int idx = idIndex.get(reporter);
                   answer[idx]++;
                }
            }
        }
        return answer;
    }
}
