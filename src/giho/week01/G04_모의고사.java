package giho.week01;

import java.util.ArrayList;

public class G04_모의고사 {

    public int[] solution(int[] answers) {

        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};

        ArrayList<Integer> resList = new ArrayList<>();
        int maxNum = -1;

        for(int i=0; i<answers.length; i++){
            int a_index = i%5;
            int b_index = i%8;
            int c_index = i%10;
            if(a[a_index] == answers[i]){
                answers[0]++;
            }
            if(b[b_index] == answers[i]){
                answers[1]++;
            }
            if(c[c_index] == answers[i]){
                answers[2]++;
            }
        }

        maxNum = Math.max(Math.max(answers[0],answers[1]),answers[2]);
        for(int i=0;i<answers.length;i++){
            if(answers[i]==maxNum){
                resList.add(i+1);
            }
        }

        

        return resList.stream().mapToInt(Integer::intValue).toArray();
    }

}
