package giho.week06;

import java.util.*;

public class G52_문자열정렬하기 {
    public String[] solution(String[] strings, int n) {

        String[] answer = Arrays.stream(strings).sorted((o1, o2) -> {
            if (o1.charAt(n) == o2.charAt(n)) {
                return o1.compareTo(o2);
            } else {
                return o1.charAt(n) - o2.charAt(n);
            }
        }).toArray(String[]::new);
        return answer;
    }
}
