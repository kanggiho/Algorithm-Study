package giho.week06;

import java.util.*;

public class G56_튜플 {

    public int[] solution(String s) {

        List<Integer> answerList = new ArrayList<>();
        HashSet<String> set = new HashSet<>();


        s=s.replace("{","");
        s=s.replace("}}","");
        String[] tempSet = s.split("},");

        Arrays.sort(tempSet, (o1,o2)->o1.length()-o2.length());

        for(int i =0 ; i<tempSet.length ; i++){
            String [] temp = tempSet[i].split(",");
            for(int j=0; j<temp.length ; j++){
                if(!set.contains(temp[j])){
                    answerList.add(Integer.parseInt(temp[j]));
                    set.add(temp[j]);
                }
            }
        }

        return answerList.stream().mapToInt(i->i).toArray();
    }

}
