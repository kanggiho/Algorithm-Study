package jino.week02;

import java.util.ArrayList;
import java.util.List;

public class J16_기능개발 {


    class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            List<Integer> sexyList = new ArrayList<>();//정답저장
            List<Integer> pro = new ArrayList<>();
            List<Integer> spd = new ArrayList<>();

            for (int i = 0; i < progresses.length; i++) {
                pro.add(progresses[i]);
                spd.add(speeds[i]);
            }

            while (!pro.isEmpty()) {
                int count = 0;
                for (int k = 0; k < pro.size(); k++) {
                    pro.set(k, pro.get(k) + spd.get(k));
                }//작업중

                while (!pro.isEmpty() && pro.get(0) >= 100) {
                    pro.remove(0);
                    spd.remove(0);
                    count++;
                }

                if (count != 0) {
                    sexyList.add(count);
                }
            }

            int[] answer = new int[sexyList.size()];
            for (int j = 0; j < answer.length; j++) {
                answer[j] = sexyList.get(j);
            }

            return answer;
        }
    }

}
