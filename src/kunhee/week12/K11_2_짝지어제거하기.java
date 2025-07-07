package kunhee.week12;

// https://school.programmers.co.kr/learn/courses/30/lessons/12973

import java.util.Stack;

public class K11_2_짝지어제거하기 {

    public static int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        // 테스트 케이스 1
        String s1 = "baabaa";
        int result1 = solution(s1);
        System.out.println(result1);  // 예상 출력: 1

        // 테스트 케이스 2
        String s2 = "cdcd";
        int result2 = solution(s2);
        System.out.println(result2);  // 예상 출력: 0
    }
}
