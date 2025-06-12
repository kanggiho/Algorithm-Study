package kunhee.week08;

// https://school.programmers.co.kr/learn/courses/30/lessons/132265

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class k63_롤케이크자르기 {

    public static int solution(int[] topping) {
        int answer = 0;

        Map<Integer, Integer> myMap = new HashMap<>();

        for (int tp : topping) {
            myMap.put(tp, myMap.getOrDefault(tp, 0) + 1);
        }

        Set<Integer> yourSet = new HashSet<>();

        for (int tp : topping) {
            myMap.put(tp, myMap.get(tp) - 1);
            if (myMap.get(tp) == 0) {
                myMap.remove(tp);
            }
            yourSet.add(tp);
            if (myMap.size() == yourSet.size()) {
                answer++;
            }
        }

        return answer;
    }

    // 테스트
    public static void main(String[] args) {
        int[] topping1 = {1, 2, 1, 3, 1, 4, 1, 2};
        int[] topping2 = {1, 2, 3, 1, 4};

        System.out.println(solution(topping1));
        System.out.println(solution(topping2));
    }
}