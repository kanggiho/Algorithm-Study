package giho.review.queue;

import java.util.*;

public class RG16_기능개발 {

    public int[] solution(int[] progresses, int[] speeds) {

        List<Integer> ansList = new ArrayList<>();

        int n = progresses.length;
        int temp = 0;

        int[] stay = new int[n];

        for(int i = 0 ; i < n ; i++){
            stay[i] = (int) Math.ceil((100-progresses[i])/(double)speeds[i]);
        }

        int inc = stay[0];

        for(int i = 0 ; i < n ; i++){
            if(inc < stay[i]){
                inc = stay[i];
                ansList.add(temp);
                temp = 1;
            }else{
                temp++;
            }
        }
        ansList.add(temp);

        return ansList.stream().mapToInt(i->i).toArray();
    }

}
