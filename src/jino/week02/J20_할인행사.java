package jino.week02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class J20_할인행사 {

    class Solution {
        public int solution(String[] want, int[] number, String[] discount) {
            int answer = 0;
            Map<String, Integer> hash = new HashMap<>();
            for (int i = 0; i < number.length; i++) {
                hash.put(want[i], number[i]);
            }

            int start = 0;
            int end = 9;

            while (end < discount.length) {
                Map<String, Integer> hashcopy = new HashMap<>(hash);
                for (int i = start; i <= end; i++) {
                    String item = discount[i];
                    if (hashcopy.containsKey(item)) {
                        hashcopy.put(item, hashcopy.get(item) - 1);
                    }
                }
                boolean flag = true;
                for (Map.Entry<String, Integer> entry : hashcopy.entrySet()) {
                    if (entry.getValue() > 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    answer++;
                }
                start++;
                end++;
            }
            return answer;
        }

    }


}
