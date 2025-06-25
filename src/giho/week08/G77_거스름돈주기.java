package giho.week08;

import java.util.*;

public class G77_거스름돈주기 {


    public static void main(String[] args) {

        int[] result = solution(123);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }


    public static int[] remain = {100, 50, 10, 1};

    static List<Integer> ansList = new ArrayList<>();

    public static int[] solution(int amount) {
        for (int i = 0; i < remain.length; i++) {
            if (amount / remain[i] != 0) {
                for (int j = 0; j < amount / remain[i]; j++) {
                    ansList.add(remain[i]);
                }
                amount -= (amount/remain[i])*remain[i];
            }
        }
        return ansList.stream().mapToInt(i -> i).toArray();
    }
}
