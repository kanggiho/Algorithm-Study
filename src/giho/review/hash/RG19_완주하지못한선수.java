package giho.review.hash;

import java.util.*;

public class RG19_완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {

        HashMap<String,Integer> com = new HashMap<>();
        for(int i = 0 ; i < completion.length ; i++){
            com.put(completion[i],com.getOrDefault(completion[i],0)+1);
        }

        for(String part : participant){
            if(com.get(part)==null||com.get(part)==0){
                return part;
            }else{
                com.put(part,com.get(part)-1);
            }
        }
        return "giho";
    }
}
