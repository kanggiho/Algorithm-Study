package giho.week03;

import java.util.HashMap;

public class G27_다단계칫솔판매 {

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = {};

        HashMap<String,String> relation = new HashMap<>();

        // 본인, 추천인 해시맵 등록
        for (int i = 0; i < enroll.length; i++) {
            relation.put(enroll[i], referral[i]);
        }







        return answer;
    }

}
