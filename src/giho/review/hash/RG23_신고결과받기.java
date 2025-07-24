package giho.review.hash;

import java.util.*;

public class RG23_신고결과받기 {

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        HashSet<String> remove = new HashSet<>(new ArrayList<>(Arrays.asList(report)));
        report = (new ArrayList<>(remove)).stream().toArray(String[]::new);

        HashMap<String, Integer> reporter = new HashMap<>();
        HashMap<String, Integer> stack = new HashMap<>();


        for(int i = 0 ; i < id_list.length ; i++){
            reporter.put(id_list[i],0);
            stack.put(id_list[i],0);
        }


        List<String> banned = new ArrayList<>();

        for(int i = 0 ; i < report.length ; i++){
            String[] temp = report[i].split(" ");
            stack.put(temp[1], stack.get(temp[1])+1);
        }

        for(Map.Entry<String, Integer> temp : stack.entrySet()){
            if(temp.getValue()>=k){
                banned.add(temp.getKey());
            }
        }

        for(int i = 0 ; i < report.length ; i++){
            String[] temp = report[i].split(" ");
            if(banned.contains(temp[1])){
                reporter.put(temp[0],reporter.get(temp[0])+1);
            }
        }

        for(int i = 0 ; i < id_list.length ; i++){
            answer[i] = reporter.get(id_list[i]);
        }

        return answer;
    }

}
