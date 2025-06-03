package heonwoo.week06;

import java.util.ArrayList;

public class H43_1부터N까지10이되는조합 {
    private static ArrayList<ArrayList<Integer>> result;
    private static int n;
    private static void backtrack(int sum, ArrayList<Integer> selectedNums, int start) {
        if (sum == 10) {
            result.add(selectedNums);
            return;
        }

        for (int i = start; i <= n; i++) {
            if (sum + i <= 10) {
                ArrayList<Integer> list = new ArrayList<>(selectedNums);
                list.add(i);

                backtrack(sum + i, list, i + 1);
            }
        }
    }
    private static ArrayList<ArrayList<Integer>> solution(int N) {
        result = new ArrayList<>();
        n = N;

        backtrack(0, new ArrayList<>(), 1);
        return result;
    }
}
