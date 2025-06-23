package jino.week12;

import java.util.Arrays;

public class J_79예산 {

    class Solution {
        public int solution(int[] d, int budget) {
            int answer = 0;
            Arrays.sort(d);
            for(int won : d){
                if(won <= budget){
                    budget -= won;
                    answer++;
                }
            }
            return answer;
        }
    }
}
