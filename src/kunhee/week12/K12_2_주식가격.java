package kunhee.week12;

// https://school.programmers.co.kr/learn/courses/30/lessons/42584

import java.util.Arrays;
import java.util.Stack;

public class K12_2_주식가격 {

    public static int[] solution(int[] prices) {
        int n = prices.length;

        int[] answer = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int index = stack.pop();
                answer[index] = i - index;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = n - 1 - index;
        }

        return answer;
    }

    public static void main(String[] args) {
        // 테스트 케이스 1
        int[] prices1 = {1, 2, 3, 2, 3};
        int[] result1 = solution(prices1);
        System.out.println(Arrays.toString(result1));  // 예상 출력: [4, 3, 1, 1, 0]
    }
}
