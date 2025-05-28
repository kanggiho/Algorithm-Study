package jino.week08;

import java.util.Arrays;

public class J_외벽점검 {
    

    class Solution {
        private static int N;
        private static int MinCnt = 0;
        private static int[] Weak;
        private static int[] Dist;

        public int solution(int n, int[] weak, int[] dist) {
            Arrays.sort(dist);
            //초기화
            N = n;
            Weak = weak;
            Dist = dist;
            MinCnt = Integer.MAX_VALUE;

            for(int i = 0 ; i < Weak.length ; i++){
                solve(1, i, 0);
            }
            if(MinCnt == Integer.MAX_VALUE){
                return -1;
            }

            return MinCnt;
        }
        private static void solve (int cnt,int pos, int visited){//친구 명수, 시작위치(weak배열 인덱스) ,방문여부)
            if(cnt > Dist.length) return;
            if(cnt >= MinCnt) return;
            for(int i = 0 ; i < Weak.length ; i++){
                int nextPos = (pos + i) % Weak.length; //시작위치가 2번째 위치여서 index를 벗어날때 구하기위해 %
                int diff = Weak[nextPos] - Weak[pos];//거리

                if(nextPos < pos ){ // 0을 지나갔다는 소리 한바귀 돔
                    diff += N;
                }

                if(diff > Dist[Dist.length - cnt]){
                    break;
                }
                visited |= 1 << nextPos;



            }
            if(visited == (1 << Weak.length ) - 1){// 모든 취약점을 다 방문 했을때(1을 왜 빼는가?)
                MinCnt = cnt;
                return;

            }
            for(int i = 0 ; i < Weak.length ; i++){
                if((visited & ( 1 << i)) != 0 ) continue;

                solve(cnt + 1, i ,visited);
            }

        }
    }
}
