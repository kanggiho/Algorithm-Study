package heonwoo.week03;

import java.util.*;

public class H27_다단계칫솔판매 {
    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};
        System.out.println(Arrays.toString(solution(enroll, referral, seller, amount)));
    }
    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, String> parentMap = new HashMap<>();
        Map<String, Integer> profitMap = new HashMap<>();

        // 트리 구조 구성
        for (int i = 0; i < enroll.length; i++) {
            parentMap.put(enroll[i], referral[i].equals("-") ? null : referral[i]);
            profitMap.put(enroll[i], 0);
        }

        // 수익 분배
        for (int i = 0; i < seller.length; i++) {
            String current = seller[i];
            int money = amount[i] * 100;

            // 부모 노드가 없는 노드(루트 노드)에 도달할때까지 아래에서 위로 탐색
            while (current != null && money > 0) {
                int give = money / 10;
                int keep = money - give;

                // 현재 수익의 10%만큼 까인 금액 적립
                profitMap.put(current, profitMap.get(current) + keep);
                current = parentMap.get(current);
                money = give;
            }
        }

        int [] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = profitMap.get(enroll[i]);
        }
        return answer;
    }
}
