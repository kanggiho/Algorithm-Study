package heonwoo.week09;

public class H67_LCS길이계산하기 {
    private static int solution(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        // LCS를 저장할 테이블 초기화
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}
