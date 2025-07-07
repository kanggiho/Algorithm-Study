package kunhee.week12;

// https://school.programmers.co.kr/learn/courses/30/lessons/159994

public class K17_2_카드뭉치 {

    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        int idx1 = 0;
        int idx2 = 0;

        for (String word : goal) {
            if (idx1 < cards1.length && word.equals(cards1[idx1])) {
                idx1++;
            } else if (idx2 < cards2.length && word.equals(cards2[idx2])) {
                idx2++;
            } else {
                return "No";
            }
        }

        return "Yes";
    }

    public static void main(String[] args) {
        // 테스트 케이스 1
        String[] cards1_1 = {"i", "drink", "water"};
        String[] cards2_1 = {"want", "to"};
        String[] goal1 = {"i", "want", "to", "drink", "water"};
        String result1 = solution(cards1_1, cards2_1, goal1);
        System.out.println(result1);  // 예상 출력: "Yes"

        // 테스트 케이스 2
        String[] cards1_2 = {"i", "water", "drink"};
        String[] cards2_2 = {"want", "to"};
        String[] goal2 = {"i", "want", "to", "drink", "water"};
        String result2 = solution(cards1_2, cards2_2, goal2);
        System.out.println(result2);  // 예상 출력: "No"
    }
}
