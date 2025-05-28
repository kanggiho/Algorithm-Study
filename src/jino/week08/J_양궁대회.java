package jino.week08;

import java.util.Arrays;

public class J_양궁대회 {

    class Solution {
        public int[] solution(int n, int[] info) {
            int[] answer = new int[11];
            int[] tmp = new int[11];
            int maxDiff = 0;

            for(int subset = 1 ; subset < (1 << 10) ; subset++){//모든 경우의 수
                int ryan = 0;
                int apeach = 0;
                int cnt = 0;
                for(int i = 0 ; i < 9 ; i++){ //i = 0 은 10점
                    if((subset & (1 << i)) != 0 ){//라이언이 이긴 경우 ex) sebset = 5 이면 101 and 논리연산
                        ryan += 10 - i;
                        tmp[i] = info[i] + 1;
                        cnt += tmp[i];
                    }else{
                        tmp[i] = 0;
                        if(info[i] > 0){
                            apeach += 10 - i;
                        }
                    }
                }
                if(cnt > n) continue;
                tmp[10] = n - cnt; // tmp[10] 은 0점

                if(ryan - apeach == maxDiff){
                    for(int i = 10 ; i >= 0 ;i--){
                        if(tmp[i] > answer[i]){
                            maxDiff = ryan - apeach;
                            answer = Arrays.copyOf(tmp, tmp.length);
                            break;
                        }else if(tmp[i] > answer[i]){
                            break;
                        }
                    }
                }
                else if(ryan - apeach > maxDiff){
                    maxDiff = ryan - apeach;
                    answer = Arrays.copyOf(tmp, tmp.length);

                }
            }
            if (maxDiff == 0){
                return new int[]{-1};
            }
            return answer;
        }
    }
}
