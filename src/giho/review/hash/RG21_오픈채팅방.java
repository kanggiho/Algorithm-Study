package giho.review.hash;

import java.util.*;

public class RG21_오픈채팅방 {

    public String[] solution(String[] record) {

        List<String> answer = new ArrayList<>();

        HashMap<String, String> data = new HashMap<>();
        HashMap<String, String> reply = new HashMap<>();

        reply.put("Enter","님이 들어왔습니다.");
        reply.put("Leave","님이 나갔습니다.");

        for(int i=0 ; i < record.length ; i++){
            String[] info = record[i].split(" ");
            if(info[0].equals("Enter")||info[0].equals("Change")){
                data.put(info[1],info[2]);
            }
        }

        for(int i =0 ; i < record.length ; i++){
            String[] info = record[i].split(" ");
            if(!info[0].equals("Change")){
                answer.add(data.get(info[1])+reply.get(info[0]));
            }
        }

        return answer.stream().toArray(String[]::new);
    }

}
