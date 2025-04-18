package heonwoo.week01;

import java.util.ArrayDeque;

public class H08_올바른괄호 {
    public static void main(String[] args) {
        String s = "()()";
        boolean answer = solution(s);
        System.out.println(answer);
    }
    public static boolean solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        char[] a = s.toCharArray();
        for (char c : a) {
            if (c == '(') {
                stack.push(c);
            }
            else { // c == ')' 일때 스택이 비어있거나 pop한 c가 ) 일때
                if(stack.isEmpty() || stack.pop() == c)
                    return false;
            }
        }

        return stack.isEmpty();
    }
}
