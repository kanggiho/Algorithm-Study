package giho.week07;

import java.util.*;

public class G63_롤케이크자르기 {

    public int solution(int[] topping) {
        int answer = 0;

        HashMap<Integer, Integer> start = new HashMap<>();
        HashMap<Integer, Integer> end = new HashMap<>();

        for (int i = 0; i < topping.length; i++) {
            end.put(topping[i], end.getOrDefault(topping[i], 0) + 1);
        }

        for (int i = 0; i < topping.length; i++) {
            start.put(topping[i], start.getOrDefault(topping[i], 0) + 1);

            if (end.get(topping[i]) == 1) {
                end.remove(topping[i]);
            } else {
                end.put(topping[i], end.getOrDefault(topping[i], 0) - 1);
            }
            if (start.size() == end.size()) {
                answer++;
            }
        }

        return answer;
    }

}