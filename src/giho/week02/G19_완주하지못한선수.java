package giho.week02;

import java.util.Arrays;

public class G19_완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        int i = 0;
        Arrays.sort(participant);
        Arrays.sort(completion);
        try{
            while (true) {
                if (!(participant[i].equals(completion[i]))) {
                    break;
                }
                i++;
            }
            return participant[i];
        }catch (Exception e) {
            return participant[i];
        }
    }
}
