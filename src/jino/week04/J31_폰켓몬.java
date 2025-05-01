package jino.week04;

import java.util.HashMap;
import java.util.Map;

public class J31_폰켓몬 {


    class Solution {
        private Map<Integer, Integer> myHash;
        private int  maxNum;
        public int solution(int[] nums) {

            maxNum = nums.length / 2;
            myHash = new HashMap<>();

            for(int n: nums){
                myHash.put(n,myHash.getOrDefault(n, 0) + 1 );
            }
            final int SIZE = myHash.size();

            if(SIZE >= maxNum){
                return maxNum;
            }
            else{
                return SIZE;
            }


        }
    }
}
