package giho.week02;

import java.util.ArrayList;

public class G16_기능개발 {

    public int[] solution(int[] progresses, int[] speeds) {
        int count = 1;


        ArrayList<Integer> answer = new ArrayList<>();

        ArrayList<Integer> days = new ArrayList<>();

        for(int i = 0; i < progresses.length; i++) {
            days.add((int)Math.ceil((double) (100 - progresses[i]) /speeds[i]));
        }

        int maxDay = days.get(0);

        for(int i = 1; i < progresses.length; i++) {
            if(days.get(i) <= maxDay) {
                count++;
            }else{
                answer.add(count);
                maxDay = days.get(i);
                count = 1;
            }
        }
        answer.add(count);

        return answer.stream().mapToInt(i -> i).toArray();

    }

}
