package giho.week06;

import java.util.*;

public class G54_K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        List<Integer> list = new ArrayList<>();

        for(int i = 0 ; i<commands.length; i++){
            int start = commands[i][0]-1;
            int end = commands[i][1]-1;
            int where = commands[i][2]-1;

            for(int j = start ; j<=end ; j++){
                list.add(array[j]);
            }

            Collections.sort(list);
            answer[i]=list.get(where);
            list.clear();
        }
        return answer;
    }
}
