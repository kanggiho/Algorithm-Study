package jino.week12;

import java.util.Arrays;

public class J81_귤고르기 {

    class Solution {
        public int solution(int k, int[] tangerine) {
            int answer = 0;
            int maxSize = 0;
            for(int size : tangerine){
                maxSize = Math.max(size , maxSize);
            }
            int[] size = new int[maxSize + 1];
            for(int i = 0 ; i < tangerine.length ; i++){
                size[tangerine[i]]++;
            }
            Arrays.sort(size);
            for(int i = size.length - 1 ; i >= 0 ;i--){
                if(k <= 0 ){
                    break;
                }

                answer++;
                k -= size[i];

            }
            return answer;
        }
    }
}
