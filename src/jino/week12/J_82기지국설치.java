package jino.week12;

public class J_82기지국설치 {
    class Solution {
        public int solution(int n, int[] stations, int w) {
            int answer = 0;
            int idx = 0 ;
            int loc = 1;
            while(loc <= n){
                if(idx < stations.length && loc >= stations[idx] - w){
                    loc = stations[idx] + w + 1;
                    idx++;
                }

                else{
                    loc += 2 * w + 1;
                    answer++;
                }
            }

            return answer;
        }
    }
}
