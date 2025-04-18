package jino.week02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class J19_완주하지못한선수 {

    class Solution {
        public String solution(String[] participant, String[] completion) {
            String answer = "";
            Map <String , Integer> hash = new HashMap<>();

            for(String p :participant){
                hash.put(p ,hash.getOrDefault(p , 0) +1);
            }

            //System.out.println(hash);

            for(String c :completion){
                hash.put(c ,hash.get(c) - 1);
            }

            // for(String key : hash.keySet()){
            //     if(hash.get(key) != 0){
            //         answer = key;
            //     }
            // }

            for(Map.Entry<String , Integer> entry : hash.entrySet()){
                if(entry.getValue() != 0){
                    answer = entry.getKey();
                }
            }

            return answer;
        }
    }
}
