package kunhee.week01;

import java.util.Stack;

public class K08_올바른괄호 {

    public static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c); // 여는 괄호면 스택에 넣고
            } else {
                if (stack.isEmpty()) {
                    return false; // 닫는 괄호인데 짝이 없으면 false
                }
                stack.pop(); // 짝 맞는 여는 괄호 꺼냄
            }
        }

        return stack.isEmpty(); // 다 짝지어졌으면 스택은 비어 있어야 함
    }

}
