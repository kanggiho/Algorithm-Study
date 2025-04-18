package heonwoo.week01;

import java.util.Stack;

public class H09_10진수를2진수로변환하기 {
    public static void main(String[] args) {
        int decimal = 12345;
        String answer = Solution(decimal);
        System.out.println(answer);
    }

    public static String Solution(int decimal) {
        Stack<Integer> stack = new Stack<>();

        while (decimal > 0) {
            int remainder = decimal % 2;
            stack.push(remainder);
            decimal /= 2;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}
