package kunhee.week11;

// https://school.programmers.co.kr/learn/courses/30/lessons/150370

import java.util.*;

public class K85_개인정보수집유효기간 {

    public static int[] solution(String today, String[] terms, String[] privacies) {

        List<Integer> answer = new ArrayList<>();

        int dDay = convert(today);

        Map<String, Integer> termsMap = new HashMap<>();

        for (int i = 0; i < terms.length; i++) {
            String[] tArray = terms[i].split(" ");
            termsMap.put(tArray[0], Integer.parseInt(tArray[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] pArray = privacies[i].split(" ");
            if (convert(pArray[0]) + 28 * termsMap.get(pArray[1]) <= dDay) {
                answer.add(i + 1);
            }
        }

        int[] a = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            a[i] = answer.get(i);
        }


        return a;
    }

    public static int convert(String date) {
        String[] parts = date.split("\\.");

        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        return 12 * 28 * year + 28 * month + day;
    }

    // 테스트
    public static void main(String[] args) {
        // 테스트 케이스 1
        String today1 = "2022.05.19";
        String[] terms1 = {"A 6", "B 12", "C 3"};
        String[] privacies1 = {
                "2021.05.02 A",
                "2021.07.01 B",
                "2022.02.19 C",
                "2022.02.20 C"
        };
        int[] result1 = solution(today1, terms1, privacies1);
        System.out.println(Arrays.toString(result1));  // 예상 출력: [1, 3]

        // 테스트 케이스 2
        String today2 = "2020.01.01";
        String[] terms2 = {"Z 3", "D 5"};
        String[] privacies2 = {
                "2019.01.01 D",
                "2019.11.15 Z",
                "2019.08.02 D",
                "2019.07.01 D",
                "2018.12.28 Z"
        };
        int[] result2 = solution(today2, terms2, privacies2);
        System.out.println(Arrays.toString(result2));  // 예상 출력: [1, 4, 5]
    }
}