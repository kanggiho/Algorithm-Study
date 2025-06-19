package jino.week11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J_68LIS길이계산하기 {

    // The main method must be in a class named "Main".
    class Main {
        private static int[][] dp;
        public static void main(String[] args) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            if(n == 1){
                System.out.println(1);
                return;
            }
            int[] dp = new int[n + 1];
            int[] arr = new int[n + 1];

            arr[0] = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 1 ; i < arr.length ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }


            for(int i = 1 ; i < arr.length ; i++){
                for(int j = 0 ; j < i ; j++){
                    if(arr[j] < arr[i]){
                        dp[i] = Math.max(dp[i], dp[j]+ 1);
                    }

                }
            }

            int max = 0;
            for(int i = 0 ;i < dp.length ; i++){
                max = Math.max(dp[i],max);
            }

            System.out.println(max);


        }
    }
}
