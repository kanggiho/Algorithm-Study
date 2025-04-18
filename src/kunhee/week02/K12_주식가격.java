package kunhee.week02;

import java.util.Stack;

public class K12_주식가격 {

    public static int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // 현재 가격이 이전보다 낮아지면
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int prev = stack.pop();
                answer[prev] = i - prev; // 몇 초 동안 유지됐는지 계산
            }
            stack.push(i); // 인덱스를 스택에 저장
        }

        // 끝까지 떨어지지 않은 경우 처리
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = n - 1 - idx;
        }

        return answer;
    }

}
