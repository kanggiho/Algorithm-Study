package jino.week11;

public class J_조약돌문제 {


    // The main method must be in a class named "Main".
    class Main {
        private static int answer = 0;
        private static int[][] dp ;
        private static int n;

        public static void main(String[] args) {
            int[][] arr1 = {{1, 3, 3, 2}, {2, 1, 4, 1}, {1, 5, 2, 3}};
            System.out.println(solution(arr1));
            int[][] arr2 = {{1, 7, 13, 2, 6}, {2, -4, 2, 5, 4}, {5, 3, 5, -3, 1}};
            System.out.println(solution(arr2));


        }
        private static int solution(int[][] arr){
            //초기화
            n = arr[0].length;
            answer = 0;
            dp = new int[4][n];
            dp[0][0] = arr[0][0];//case 1 >> case2,case3
            dp[1][0] = arr[1][0];//case 2 >> case1, case3, case 4
            dp[2][0] = arr[2][0];//case 3 >> case 2, case 1
            dp[3][0] = arr[0][0] + arr[2][0];//case 4 >> case2

            for(int i = 1 ; i < n ; i++){
                dp[0][i] = arr[0][i] + Math.max(dp[1][i - 1], dp[2][i - 1]);//현재 1번 선택시
                dp[1][i] = arr[1][i] + Math.max(dp[0][i - 1],Math.max(dp[2][i - 1], dp[3][i - 1]));//현재 2번 선택시
                dp[2][i] = arr[2][i] + Math.max(dp[1][i - 1], dp[0][i - 1]);//현재 3번 선택시
                dp[3][i] = arr[0][i] + arr[2][i] + dp[1][i - 1];//현재 4번 선택시
            }

            for(int i = 0 ; i < 4 ; i++){
                answer = Math.max(answer, dp[i][dp[0].length - 1]);
            }
            return answer;
        }
    }
}
