package kunhee.week12;

// https://school.programmers.co.kr/learn/courses/30/lessons/49994

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class K07_2_방문길이 {

    public static int solution(String dirs) {

        int[] loc = new int[2];

        Set<String> set = new HashSet<>();

        for (int i = 0; i < dirs.length(); i++) {
            if (dirs.charAt(i) == 'U') {
                if (loc[1] != 5) {
                    loc[1] += 1;
                    String s = String.format("%d,%d/%d,%d", loc[0], loc[1] - 1, loc[0], loc[1]);
                    set.add(s);
                }
            } else if (dirs.charAt(i) == 'D') {
                if (loc[1] != -5) {
                    loc[1] -= 1;
                    String s = String.format("%d,%d/%d,%d", loc[0], loc[1], loc[0], loc[1] + 1);
                    set.add(s);
                }
            } else if (dirs.charAt(i) == 'R') {
                if (loc[0] != 5) {
                    loc[0] += 1;
                    String s = String.format("%d,%d/%d,%d", loc[0] - 1, loc[1], loc[0], loc[1]);
                    set.add(s);
                }
            } else {
                if (loc[0] != -5) {
                    loc[0] -= 1;
                    String s = String.format("%d,%d/%d,%d", loc[0], loc[1], loc[0] + 1, loc[1]);
                    set.add(s);
                }
            }
        }

        return set.size();
    }

    public static void main(String[] args) {
        // 테스트 케이스 1
        String dirs1 = "ULURRDLLU";
        int result1 = solution(dirs1);
        System.out.println(result1);  // 예상 출력: 7

        // 테스트 케이스 2
        String dirs2 = "LULLLLLLU";
        int result2 = solution(dirs2);
        System.out.println(result2);  // 예상 출력: 7
    }
}
