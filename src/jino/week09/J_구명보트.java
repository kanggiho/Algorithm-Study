package jino.week09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class J_구명보트 {

    class Solution {
        public int solution(int[] people, int limit) {
            int answer = 0;
            int start = 0;
            int end = people.length - 1;
            Arrays.sort(people);

            while(start <= end){
                if(people[end] + people[start] <= limit){
                    answer++;
                    start++;
                    end--;
                }
                else if(people[end] + people[start] > limit){
                    end--;
                    answer++;
                }
            }
            return answer;
        }
    }
}
