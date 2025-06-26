package heonwoo.week10;

import java.util.ArrayList;

public class H77_거스름돈주기{
    public static int[] solution(int amount) {
        int[] money = {100, 50, 10, 1};

        ArrayList<Integer> change = new ArrayList<>();
        for (int coin : money) {
            while (amount >= coin) {
                change.add(coin);
                amount -= coin;
            }
        }

        // 리스트 배열로 변경하여 반환
        return change.stream().mapToInt(Integer::intValue).toArray();
    }
}
