package giho.week03;

import java.util.HashMap;

public class G27_다단계칫솔판매 {

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        HashMap<String, String> relation = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            relation.put(enroll[i], referral[i]);
        }

        HashMap<String, Integer> profit = new HashMap<>();

        for (int i = 0; i < seller.length; i++) {
            String tempSeller = seller[i];
            int money = amount[i] * 100;

            while (true) {
                int commission = money / 10;
                int selfProfit = money - commission;

                profit.put(tempSeller, profit.getOrDefault(tempSeller, 0) + selfProfit);

                if (!relation.containsKey(tempSeller) || relation.get(tempSeller).equals("-") || commission == 0) {
                    break;
                }

                tempSeller = relation.get(tempSeller);
                money = commission;
            }
        }

        for (int i = 0; i < enroll.length; i++) {
            answer[i] = profit.getOrDefault(enroll[i], 0);
        }

        return answer;
    }

}
