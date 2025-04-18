package kunhee.week01;

import java.util.Stack;

public class K09_10진수를2진수로변환하기 {

    public static String solution(int decimal) {
        Stack<Integer> stack = new Stack<>();

        // 2로 나눈 나머지를 스택에 push
        while (decimal > 0) {
            stack.push(decimal % 2);
            decimal = decimal / 2;
        }

        // 스택에서 꺼내면서 문자열로 붙이기
        StringBuilder binary = new StringBuilder();
        while (!stack.isEmpty()) {
            binary.append(stack.pop());
        }

        return binary.toString();
    }

}
