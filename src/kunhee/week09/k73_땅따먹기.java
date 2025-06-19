package kunhee.week09;

// https://school.programmers.co.kr/learn/courses/30/lessons/12913

public class k73_땅따먹기 {

    public static int solution(int[][] land) {
        int n = land.length;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                int max = 0;

                for (int k = 0; k < 4; k++) {
                    if (j != k) max = Math.max(max, land[i - 1][k]);
                }

                land[i][j] += max;
            }
        }

        return Math.max(
                Math.max(land[n-1][0], land[n-1][1]),
                Math.max(land[n-1][2], land[n-1][3])
        );
    }

    // 테스트
    public static void main(String[] args) {
        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        System.out.println(solution(land));
    }
}