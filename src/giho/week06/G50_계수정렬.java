package giho.week06;

import java.util.*;

public class G50_계수정렬 {
    public static void main(String[] args) {
        solution("algorithm");
    }

    public static void solution(String s) {

        int[] frequency = new int[26];

        for (char c : s.toCharArray()) {
            frequency[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < frequency[i]; j++) {
                sb.append((char)('a' + i));
            }
        }

        System.out.println(sb);


    }


}
