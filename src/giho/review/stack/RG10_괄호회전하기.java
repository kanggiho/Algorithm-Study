package giho.review.stack;

import java.util.*;

public class RG10_괄호회전하기 {
    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            String newS = s.substring(i) + s.substring(0, i);
            if (isValid(newS)) {
                answer++;
            }
        }
        return answer;
    }


    public boolean isValid(String s) {
        boolean valid = true;
        char[] c = s.toCharArray();

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(') stack.push(1);
            if (c[i] == '{') stack.push(2);
            if (c[i] == '[') stack.push(3);

            if (c[i] == ')') {
                if (!stack.isEmpty()) {
                    if (stack.pop() != 1) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            if (c[i] == '}') {
                if (!stack.isEmpty()) {
                    if (stack.pop() != 2) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            if (c[i] == ']') {
                if (!stack.isEmpty()) {
                    if (stack.pop() != 3) {
                        return false;
                    }
                } else {
                    return false;
                }
            }

        }

        if (!stack.isEmpty()) {
            return false;
        }
        return true;

    }
}
