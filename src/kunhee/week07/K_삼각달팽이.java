package kunhee.week07;

import java.util.*;

public class K_삼각달팽이 {

    public static int[] solution(int n) {
        int[][] arr = new int[n][n];
        int num = 1;
        int x = -1, y = 0;
        int count = n;

        for (int d = 0; count > 0; d++, count--) {
            for (int i = 0; i < count; i++) {
                if (d % 3 == 0) { // 아래
                    x++;
                } else if (d % 3 == 1) { // 오른쪽
                    y++;
                } else { // 왼쪽 위 대각선
                    x--;
                    y--;
                }
                arr[x][y] = num++;
            }
        }

        // 결과를 1차원 배열로 변환
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                result.add(arr[i][j]);
            }
        }

        // 리스트를 배열로 변환
        return result.stream().mapToInt(i -> i).toArray();
    }

    // 테스트
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(4)));
        System.out.println(Arrays.toString(solution(5)));
        System.out.println(Arrays.toString(solution(6)));
    }
}