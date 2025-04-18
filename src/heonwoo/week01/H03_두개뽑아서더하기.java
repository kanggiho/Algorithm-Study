package heonwoo.week01;

import java.util.ArrayList;
import java.util.Arrays;

public class H03_두개뽑아서더하기 {
    public static void main(String[] args) {
        int[] numbers = {5, 0, 2, 7};
        int[] result = solution(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(result));
    }

    private static int[] solution(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int a = numbers[i] + numbers[j];
                if (list.indexOf(a) < 0) { // 각각 더한 값의 인덱스가 존재하지않으면 list에 추가
                    list.add(a);
                }
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}
