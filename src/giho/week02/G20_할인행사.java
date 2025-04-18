package giho.week02;

import java.util.HashMap;
import java.util.Map;

public class G20_할인행사 {

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int days = 10;

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < want.length; i++){
            map.put(want[i], number[i]);
        }

        for(int i = 0; i < discount.length - days + 1; i++){
            Map<String, Integer> disCountMap = new HashMap<>();

            for(int j = 0; j < days; j++){
                disCountMap.put(discount[i + j], disCountMap.getOrDefault(discount[i + j], 0) + 1);
            }

            boolean isIdentical = true;

            for(String key : map.keySet()){
                if(!map.get(key).equals(disCountMap.get(key))){
                    isIdentical = false;
                    break;
                }
            }

            answer += isIdentical ? 1 : 0;
        }

        return answer;
    }
}
