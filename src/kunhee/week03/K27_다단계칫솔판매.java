package kunhee.week03;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class K27_다단계칫솔판매 {

    public static int[] solution(
            String[] enroll,
            String[] referral,
            String[] seller,
            int[] amount
    ) {
        int n = enroll.length;
        int[] finalProfit = new int[n];
        int[] parent = new int[n];
        Map<String, Integer> indexMap = new HashMap<>();

        // 1. 이름 - 인덱스 매핑
        for (int i = 0; i < n; i++) {
            indexMap.put(enroll[i], i);
        }

        // 2. 부모 정보 저장
        for (int i = 0; i < n; i++) {
            if (referral[i].equals("-")) {
                parent[i] = -1;
            } else {
                parent[i] = indexMap.get(referral[i]);
            }
        }

        // 3. 판매 이익 전파
        for (int i = 0; i < seller.length; i++) {
            String name = seller[i];
            int profit = amount[i] * 100;

            int now = indexMap.get(name);
            while (now != -1 && profit > 0) {
                int give = profit / 10;
                int keep = profit - give;

                finalProfit[now] += keep;

                profit = give;
                now = parent[now];
            }
        }

        return finalProfit;
    }

}
