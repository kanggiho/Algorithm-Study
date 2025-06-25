package giho.week08;

import java.util.*;

public class G80_구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int iter1 = 0;
        int iter2 = people.length-1;
        Arrays.sort(people);

        while(iter1<=iter2){
            if(people[iter2]+people[iter1]<=limit){
                iter1++;
            }
            iter2--;
            answer++;
        }
        return answer;
    }
}
