package jino.week11;

public class J_2n타일링 {
    class Solution {
        private static int answer = 0;
        private static int[] dp;
        public int solution(int n) {
            dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            for(int i = 3 ; i < dp.length ; i++){
                dp[i] = (dp[i - 1] + dp[i - 2] )% 1000000007;
            }
            return dp[n];
        }
    }
}
