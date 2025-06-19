package jino.week11;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class J_67LCS길이계산하기 {

    // The main method must be in a class named "Main".
    class Main {
        private static int[][] dp;
        public static void main(String[] args) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str1 = br.readLine();//행방향
            String str2 = br.readLine();//열방향
            dp = new int[str2.length() + 1][str1.length() + 1];

            for(int i = 1 ; i < dp.length  ; i++){
                for(int j = 1 ; j < dp[i].length  ; j++){
                    if(str1.charAt(j - 1) == str2.charAt(i - 1)){//같은상황
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    else{
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            System.out.println(dp[dp.length - 1][dp[0].length - 1]);



        }
    }
}
