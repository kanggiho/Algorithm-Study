package kunhee.week02;

import java.util.Stack;

public class K11_짝지어제거하기 {

    public static int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop(); // 짝이면 제거
            } else {
                stack.push(c); // 아니면 쌓기
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }

}
