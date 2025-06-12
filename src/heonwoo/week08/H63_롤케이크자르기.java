package heonwoo.week08;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class H63_롤케이크자르기 {
    public int solution(int[] topping) {
        int answer = 0;

        Map<Integer, Integer> brother = new HashMap<>();
        Set<Integer> bro = new HashSet<>();

        // 먼저 동생이 전부 가지고 있다고 가정
        for (int t : topping) {
            brother.put(t, brother.getOrDefault(t, 0) + 1);
        }

        for (int i = 0; i < topping.length; i++) {
            int t = topping[i];

            // 형이 하나 가져감
            bro.add(t);
            brother.put(t, brother.get(t) - 1);

            if (brother.get(t) == 0) {
                brother.remove(t);
            }

            // 둘의 종류 수가 같으면 카운트
            if (bro.size() == brother.size()) {
                answer++;
            }
        }

        return answer;
    }
}
