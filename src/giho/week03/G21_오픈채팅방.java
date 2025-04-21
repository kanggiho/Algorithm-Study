package giho.week03;

import java.util.*;

public class G21_오픈채팅방 {

    public String[] solution(String[] record) {
        HashMap<String, String> users = new HashMap<>();
        ArrayList<String> answerList = new ArrayList<>();

        for(String rec : record) {
            String[] tempRecord = rec.split(" ");
            switch (tempRecord[0]) {
                case "Enter", "Change" -> {
                    users.put(tempRecord[1], tempRecord[2]);
                }
            }
        }

        for(String rec : record) {
            String[] tempRecord = rec.split(" ");
            switch (tempRecord[0]) {
                case "Enter" -> {
                    answerList.add(users.get(tempRecord[1])+"님이 들어왔습니다.");
                }
                case "Leave" -> {
                    answerList.add(users.get(tempRecord[1])+"님이 나갔습니다.");
                }
            }

        }
        return answerList.toArray(String[]::new);
    }
}
