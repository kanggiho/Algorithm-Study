package kunhee.week01;

import java.util.*;

public class K03_두개뽑아서더하기 {

    public static int[] solution(int[] numbers) {
        // 중복값 제거용
        Set<Integer> sumSet = new HashSet<>();

        // j는 i+1부터 시작하면 중복 계산 방지
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                sumSet.add(numbers[i] + numbers[j]);
            }
        }

        // Set -> List 변환 후 정렬
        List<Integer> resultList = new ArrayList<>(sumSet);
        Collections.sort(resultList);

        // List -> int[] 변환
        int[] result = new int[resultList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}
