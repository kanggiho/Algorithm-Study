package kunhee.week09;

/*
문제 설명:
주어진 두 개의 문자열 str1과 str2에 대해 최장 공톤 부분 수열의 길이를 계산하는 solution() 함수를 구현하세요.

제약조건:
- 각 문자열 str1과 str2의 길이는 1 이상 1,000 이하입니다.
- 문자열은 알파벳 대문자, 소문자로만 구성되어 있습니다.
*/

public class k67_LCS길이계산하기 {

    public static int solution(String str1, String str2) {

        int x = str1.length();
        int y = str2.length();

        int[][] dp = new int[x+1][y+1];

        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[x][y];
    }

    // 테스트
    public static void main(String[] args) {
        String str1 = "ABCBDAB";
        String str2 = "BDCAB";
        System.out.println(solution(str1, str2));
        String str3= "AGGTAB";
        String str4 = "GXTXAYB";
        System.out.println(solution(str3, str4));
        String str5= "abcdefg";
        String str6 = "afcbcsgdafefG";
        System.out.println(solution(str5, str6));
    }
}