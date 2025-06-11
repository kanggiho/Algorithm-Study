package kunhee.week07;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class k56_튜플 {

    public static int[] solution(String s) {

        //int n = 0; // n = 튜플 원소의 개수
        //int count = n * (n-1) / 2 + n - 1; // n > 1 일 때, String s 에 포함된 ','의 개수

        String cleaned = s.replaceAll("[{}]", "");

        String[] tokens = cleaned.split(",");

        Map<Integer, Integer> countMap = new HashMap<>();

        for (String token : tokens) {
            int num = Integer.parseInt(token);
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int n = countMap.size();

        int[] result = new int[n];

        for (int i = 0; i < countMap.size(); i++) {
            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                if (entry.getValue() == n) {
                    result[i] = entry.getKey();
//                    n--;
//                    break;
                }
            }
            n--;
        }

        return result;
    }

    // 테스트
    public static void main(String[] args) {
        String s1 = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        String s2 = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        String s3 = "{{20,111},{111}}";
        String s4 = "{{123}}";
        String s5 = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
        System.out.println(Arrays.toString(solution(s1)));
        System.out.println(Arrays.toString(solution(s2)));
        System.out.println(Arrays.toString(solution(s3)));
        System.out.println(Arrays.toString(solution(s4)));
        System.out.println(Arrays.toString(solution(s5)));
    }
}