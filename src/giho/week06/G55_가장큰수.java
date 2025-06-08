package giho.week06;

import java.util.*;

public class G55_가장큰수 {

    public String solution(int[] numbers) {
        List<String> numStrings = new ArrayList<>();
        int sum = 0;
        for (int num : numbers) {
            numStrings.add(String.valueOf(num));
            sum += num;
        }

        if (sum == 0) return "0";

        numStrings.sort((a, b) -> (b + a).compareTo(a + b));

        StringBuilder answer = new StringBuilder();
        for (String s : numStrings) {
            answer.append(s);
        }

        return answer.toString();
    }

}
