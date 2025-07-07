package kunhee.week09;

/*
문제 설명:
3행 N열의 가중치가 있는 배열 arr이 주어집니다.
이 배열에 다음 규칙을 준수하면서 조약돌을 놓을 때, 최대 가중치의 합을 반환하는 solution() 함수를 구현하세요.

제약조건:
- 각 열에 조약돌은 적어도 하나는 놓아야 합니다.
- 각 조약돌에 바로 인접한 위치에 조약돌을 놓을 수 없습니다.
  - 인접 기준은 상하좌우입니다.
*/

public class K69_조약돌문제 {

    public static int solution(int[][] arr) {

        // 1. 앞에서부터 돌을 두기 어렵다
        // 2. 정답이 있다고 가정하고 마지막 돌 위치부터 역으로 생각
        // 3. 마지막 열의 경우의 수는 4가지 (상단, 중단, 하단, 상단+하단)

        int n = arr[0].length;

        int[][] dp = new int[4][n];

        dp[0][0] = arr[0][0];
        dp[1][0] = arr[1][0];
        dp[2][0] = arr[2][0];
        dp[3][0] = arr[0][0] + arr[2][0];

        for (int i = 1; i < n; i++) {
            dp[0][i] = arr[0][i] + Math.max(dp[1][i - 1], dp[2][i - 1]);
            dp[1][i] = arr[1][i] + Math.max(dp[3][i - 1], Math.max(dp[0][i - 1], dp[2][i - 1]));
            dp[2][i] = arr[2][i] + Math.max(dp[0][i - 1], dp[1][i - 1]);
            dp[3][i] = arr[0][i] + arr[2][i] + dp[1][i - 1];
        }

        return Math.max(Math.max(dp[0][n - 1], dp[1][n - 1]), Math.max(dp[2][n - 1], dp[3][n - 1]));
    }

    // 테스트
    public static void main(String[] args) {
        int[][] arr1 = {{1, 3, 3, 2}, {2, 1, 4, 1}, {1, 5, 2 ,3}};
        System.out.println(solution(arr1));

        int[][] arr2 = {{1, 7, 13, 2, 6}, {2, -4, 2, 5, 4}, {5, 3, 5, -3 ,1}};
        System.out.println(solution(arr2));
    }
}