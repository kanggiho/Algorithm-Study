package giho.week04;

import java.util.*;


public class G32_영어끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        int tempNum = 0;
        int tempStage = 0;
        char end = words[0].charAt(words[0].length()-1);

        HashSet<String> hs = new HashSet<>();

        for(int i = 0 ;i <words.length; i++){
            tempNum = i%n+1;
            tempStage = i/n+1;

            if(words[i].charAt(0)!=end){
                if(i!=0){
                    answer[0]=tempNum;
                    answer[1]=tempStage;
                    System.out.println(tempNum+" "+tempStage);
                    break;
                }
            }

            int tempSize = hs.size();
            int cloneSize = tempSize;
            hs.add(words[i]);
            tempSize = hs.size();
            if(tempSize==cloneSize){
                answer[0]=tempNum;
                answer[1]=tempStage;
                break;
            }
            end = words[i].charAt(words[i].length()-1);
        }

        return answer;
    }
}
