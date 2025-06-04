package jino.week6;

import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class J_햄버거만들기 {

    class Solution {
        public int solution(int[] ingredient) {
            List<Integer> hamList = Arrays.stream(ingredient)
                    .boxed()
                    .collect(Collectors.toList());
            int answer = 0;
            int start = 0;

            while (start <= hamList.size() - 4) {
                if (hamList.get(start) == 1 &&
                        hamList.get(start+1) == 2 &&
                        hamList.get(start+2) == 3 &&
                        hamList.get(start+3) == 1) {


                    for (int i = 3; i >= 0; i--) {
                        hamList.remove(start + i);
                    }

                    answer++;
                    start = Math.max(0, start - 3); // 안전한 되돌아가기
                } else {
                    start++;
                }
            }

            return answer;
        }
    }

}
