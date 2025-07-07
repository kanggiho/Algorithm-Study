package kunhee.week10;

/*
문제 설명:
당신은 상점에서 계산를 마치고 거스름돈을 돌려받아야 합니다.
다만 거스름돈을 최소한의 화폐수로 받고 싶어졌습니다.
거스름돈 amount가 있을 때 화폐 단위 [1, 10, 50, 100]을
최소한으로 사용한 화폐 리스트를 반환하는 solution() 함수를 반환하세요.

제약조건:
- 반환하는 값의 화폐 단위는 내림차순이어야 합니다.
- amount는 자연수입니다.
- 화폐 단위는 1, 10, 50, 100이며 화폐 개수는 무한입니다.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class K77_거스름돈주기 {

    public static int[] solution(int amount) {
        int[] coins = {100, 50, 10, 1};
        int count = 0;
        List<Integer> list = new ArrayList<>();

        for (int coin : coins) {
            count = amount / coin;
            // amount = amount % coin; -- 1번

            for (int i = 0; i < count; i++) {
                list.add(coin);
                amount -= coin; // -- 2번
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    // 테스트
    public static void main(String[] args) {
        int amount1 = 123;
        System.out.println(Arrays.toString(solution(amount1)));

        int amount2 = 350;
        System.out.println(Arrays.toString(solution(amount2)));
    }
}