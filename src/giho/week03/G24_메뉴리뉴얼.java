package giho.week03;

import java.util.*;

public class G24_메뉴리뉴얼 {

    public String[] solution(String[] orders, int[] course) {

        ArrayList<String> answerList = new ArrayList<>();
        ArrayList<String> combinations = new ArrayList<>();
        Map<String, Integer> comboCount = new HashMap<>();

        // 부분 조합 만들기
        for (int i = 0; i < course.length; i++) {
            for (int j = 0; j < orders.length; j++) {
                // 사전 순서대로 정렬
                char[] chars = orders[j].toCharArray();
                Arrays.sort(chars);
                generateCombinations("",new String(chars) ,course[i],0,combinations);
            }
        }

        // 부분 조합이 같은 경우 맵에 저장 , ex)["AC",3] ,["BC",5]
        for (String combo : combinations) {
            comboCount.put(combo, comboCount.getOrDefault(combo, 0) + 1);
        }

        // 코스별로 가장 많은 것 찾기
        for (int cour : course) {
            // 가장 많은 것을 넣을 변수
            int max = 0;

            List<String> temp = new ArrayList<>();

            for (Map.Entry<String, Integer> entry : comboCount.entrySet()) {
                String combo = entry.getKey();
                int count = entry.getValue();

                // 최대인것 임시 리스트에 넣기
                if (combo.length() == cour && count >= 2) {
                    if (count > max) {
                        max = count;
                        temp.clear();
                        temp.add(combo);
                    } else if (count == max) {
                        temp.add(combo);
                    }
                }
            }

            answerList.addAll(temp);
        }

        // 정렬 후 배열로 변환
        Collections.sort(answerList);
        return answerList.toArray(new String[0]);

    }

    // 부분조합 만드는 함수
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