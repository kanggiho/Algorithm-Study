package utils;

import java.util.Stack;

public class U06_Stack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // 요소 추가
        stack.push(1);

        // 요소 제거 (꺼내기)
        stack.pop();

        // 스택 비우기
        stack.clear();

        // 스택 크기 체크
        stack.size();

        // 스택이 비어있는지 여부 확인
        stack.empty();

        // 스택에 요소 존재하는지 확인
        stack.contains(1);

        // 스택 최상단 요소 확인 (pop()과 달리 제거하지 않음)
        stack.peek();
    }
}
