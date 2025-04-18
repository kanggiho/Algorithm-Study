package kunhee.week02;

import java.util.HashMap;
import java.util.Map;

public class K20_할인행사 {
    public static int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wantMap = new HashMap<>();
        Map<String, Integer> discountMap = new HashMap<>();
        int answer = 0;

        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        // 초기 10일 구간
        for (int i = 0; i < 10; i++) {
            discountMap.put(discount[i], discountMap.getOrDefault(discount[i], 0) + 1);
        }
        if (discountMap.equals(wantMap)) {
            answer++;
        }

        for (int i = 10; i < discount.length; i++) {
            String out = discount[i - 10]; // 빠지는 단어
            String in = discount[i];       // 새로 들어오는 단어

            // 제거
            discountMap.put(out, discountMap.get(out) - 1);
            if (discountMap.get(out) == 0) {
                discountMap.remove(out); // 0이면 key 제거
            }

            // 추가
            discountMap.put(in, discountMap.getOrDefault(in, 0) + 1);

            // 비교
            if (discountMap.equals(wantMap)) {
                answer++;
            }
        }

        return answer;
    }
}
