package jino.week09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class J_55가장큰수 {

    class Solution {
        private static String answer = "";
        List<String> myList;
        public String solution(int[] numbers) {
            myList = new ArrayList<>();
            for(int i = 0 ; i < numbers.length ; i++){
                myList.add(numbers[i] +"");
            }
            Collections.sort(myList,(o1, o2)->{
                int a = Integer.parseInt(o1 + o2);
                int b = Integer.parseInt(o2 + o1);
                return b - a;
            });

            StringBuilder sb = new StringBuilder();
            for(String str : myList){
                sb.append(str);
            }

            return sb.charAt(0) == '0' ? "0": sb.toString();
        }

    }
}
