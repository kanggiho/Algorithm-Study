package jino.week09;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class J_56튜플 {

    class Solution {
        public int[] solution(String s) {

            s = s.substring(0, s.length() - 2).replace("{","");
            String[] arr = s.split("},");

            Arrays.sort(arr, (o1, o2) ->{
                return o1.length() - o2.length();
            });
            // for(int i = 0 ; i < arr.length ;i++){
            //     System.out.println(arr[i]);
            // }
            Set<Integer> mySet = new HashSet<>();
            int[] answer = new int[arr.length];

            for(int i = 0 ; i < arr.length ; i++){
                String[] sArr = arr[i].split(",");
                for(String num : sArr){
                    int numI = Integer.parseInt(num);
                    if(!mySet.contains(numI)){
                        answer[i] = numI;
                        mySet.add(numI);
                    }
                }
            }



            return answer;
        }
    }
}
