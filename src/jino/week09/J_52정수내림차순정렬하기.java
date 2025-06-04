package jino.week09;

import java.util.Arrays;

public class J_52정수내림차순정렬하기 {
    
    class Solution {
        private static long answer = 0;

        public long solution(long n) {
            String strN = n +"";
            char[] arr = strN.toCharArray();
            // System.out.println(arr.length);
            Arrays.sort(arr);
            strN ="";
            for(int i = arr.length -1 ; i >= 0 ; i--){
                strN += arr[i]+"";
            }
            answer = Long.parseLong(strN);
            return answer;
        }
    }
}
