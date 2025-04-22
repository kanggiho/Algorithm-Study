package giho.week03;

import java.util.*;

public class G24_메뉴리뉴얼 {

    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        ArrayList<String> combinations = new ArrayList<>();

        for (int i = 0; i < course.length; i++) {
            for (int j = 0; j < orders.length; j++) {
                generateCombinations("",orders[j],course[i],0,combinations);
            }
        }

        return answer;
    }

    void generateCombinations(String path, String input, int r, int index, List<String> result) {
        if (path.length() == r) {
            result.add(path);
            return;
        }

        for (int i = index; i < input.length(); i++) {
            generateCombinations(path + input.charAt(i), input, r, i + 1, result);
        }
    }
}
