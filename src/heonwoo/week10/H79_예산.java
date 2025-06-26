package heonwoo.week10;

import java.util.Arrays;

public class H79_예산 {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int count = 0;

        for (int amount : d) {
            if (budget < amount) {
                break;
            }
            budget -= amount;
            count++;
        }
        return budget >= 0 ? count : count - 1;
    }
}
