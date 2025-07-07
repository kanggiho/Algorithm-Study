package kunhee.week12;

// https://school.programmers.co.kr/learn/courses/30/lessons/42586

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class K16_2_기능개발 {

    public static int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        for (int i = speeds.length - 1; i >= 0 ; i--) {
            stack.push(((100 - progresses[i]) + speeds[i] - 1) / speeds[i]);
        }

        while (!stack.isEmpty()) {
            int count = 1;
            int top = stack.pop();

            while (!stack.isEmpty() && stack.peek() <= top) {
                stack.pop();
                count++;
            }

            list.add(count);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        // 테스트 케이스 1
        int[] progresses1 = {93, 30, 55};
        int[] speeds1 = {1, 30, 5};
        int[] result1 = solution(progresses1, speeds1);
        System.out.println(Arrays.toString(result1));  // 예상 출력: [2, 1]

        // 테스트 케이스 2
        int[] progresses2 = {95, 90, 99, 99, 80, 99};
        int[] speeds2 = {1, 1, 1, 1, 1, 1};
        int[] result2 = solution(progresses2, speeds2);
        System.out.println(Arrays.toString(result2));  // 예상 출력: [1, 3, 2]
    }
}
