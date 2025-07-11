package jino.week13;

public class J_택배배달과수거하기 {
    public static void main(String[] args) {
        class Solution {
            public long solution(int cap, int n, int[] deliveries, int[] pickups) {
                long answer = 0;
                int dCap = 0;
                int pCap = 0;

                for(int i = n - 1 ; i >= 0 ;i--){
                    //dCap 양수이면 배달을 하러 가야함
                    //음수이면 여유 분이 있다.
                    dCap += deliveries[i];
                    pCap += pickups[i];
                    while(dCap > 0 || pCap > 0){//배달하러 가야함
                        dCap -= cap;
                        pCap -= cap;
                        answer += i + 1;
                    }
                }

                return answer * 2;
            }
        }
    }
}
