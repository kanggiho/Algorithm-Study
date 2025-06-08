package giho.week06;

import java.util.*;


public class G53_정수내림차순 {
    public long solution(long n) {
        long answer = 0;
        String str = String.valueOf(n);

        char[] newChar = str.toCharArray();

        Arrays.sort(newChar);

        StringBuilder sb = new StringBuilder();
        sb.append(new String(newChar));
        sb.reverse();

        return Long.parseLong(sb.toString());
    }
}
