package kunhee.week12;

// https://school.programmers.co.kr/learn/courses/30/lessons/77486

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class K27_2_다단계칫솔판매 {

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        // gpt 도움

        int[] answer = new int[enroll.length];

        // key: 이름, value: enroll에서의 index
        Map<String, Integer> idxMap = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            idxMap.put(enroll[i], i);
        }

        // 추천인 인덱스 배열: 추천인이 없으면 -1
        int[] parent = new int[enroll.length];

        for (int i = 0; i < enroll.length; i++) {
            parent[i] = referral[i].equals("-") ? -1 : idxMap.get(referral[i]);
        }

        // 수익 분배
        for (int i = 0; i < seller.length; i++) {

            int idx = idxMap.get(seller[i]);
            int money = amount[i] * 100;

            while (idx != -1) {
                int give = money / 10;
                int earn = money - give;

                answer[idx] += earn;

                if (give < 1) break;

                idx = parent[idx];
                money = give;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // 테스트 케이스 1
        String[] enroll1 = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral1 = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller1 = {"young", "john", "tod", "emily", "mary"};
        int[] amount1 = {12, 4, 2, 5, 10};
        int[] result1 = solution(enroll1, referral1, seller1, amount1);
        System.out.println(Arrays.toString(result1));
        // 예상 출력: [360, 958, 108, 0, 450, 18, 180, 1080]

        // 테스트 케이스 2
        String[] enroll2 = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral2 = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller2 = {"sam", "emily", "jaimie", "edward"};
        int[] amount2 = {2, 3, 5, 4};
        int[] result2 = solution(enroll2, referral2, seller2, amount2);
        System.out.println(Arrays.toString(result2));
        // 예상 출력: [0, 110, 378, 180, 270, 450, 0, 0]
    }
}
