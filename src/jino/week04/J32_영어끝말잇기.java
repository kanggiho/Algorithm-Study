package jino.week04;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class J32_영어끝말잇기 {

    class Solution {
        private static Set<String> checkWord;
        private static List<String> checkEnd;
        public int[] solution(int n, String[] words) {
            checkWord = new HashSet<>();
            checkEnd = new ArrayList<>();
            int[] answer = new int[2];
            checkWord.add(words[0]);
            checkEnd.add(words[0]);
            final int LENGTH = words.length;

            for(int i = 1 ; i <LENGTH ;i++){
                int beforeSize = checkWord.size();
                checkWord.add(words[i]);
                checkEnd.add(words[i]);
                int afterSize = checkWord.size();
                if(beforeSize == afterSize){
                    // System.out.println(i);
                    if((i +1) % n == 0){
                        answer[0] = n;
                    }
                    else{
                        answer[0] = (i +1) % n;
                    }
                    answer[1] = (int)(Math.ceil((double)(i+1)/n));
                    break;
                }
                if(checkEnd.get(i-1).charAt(checkEnd.get(i-1).length()-1)
                        != checkEnd.get(i).charAt(0)){
                    System.out.println(i);
                    if((i +1) % n == 0){
                        answer[0] = n;
                    }
                    else{
                        answer[0] = (i +1) % n;
                    }

                    answer[1] = (int)(Math.ceil((double)(i+1)/n));
                    break;
                }
            }





            return answer;
        }
    }
}
