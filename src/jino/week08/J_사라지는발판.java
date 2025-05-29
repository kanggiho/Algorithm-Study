package jino.week08;

public class J_사라지는발판 {
    

    class Solution {
        private static int[][] D = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        private static int[][] Board;
        private static int N, M;

        public int solution(int[][] board, int[] aloc, int[] bloc) {
            Board = board;
            N = board.length;
            M = board[0].length;

            return calc(aloc[0], aloc[1], bloc[0], bloc[1]);
        }

        private static int calc(int arow, int acol, int brow, int bcol) {
            // 현재 플레이어가 서있는 발판이 없으면 즉시 패배
            if(Board[arow][acol] == 0) return 0;

            int ret = 0;
            Board[arow][acol] = 0; // 현재 발판 제거

            for(int i = 0; i < 4; i++) {
                int nr = arow + D[i][0];
                int nc = acol + D[i][1];

                // 범위 체크
                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                // 발판이 없으면 이동 불가
                if(Board[nr][nc] == 0) continue;

                // 상대방 턴으로 재귀 호출
                int cnt = 1 + calc(brow, bcol, nr, nc);

                if(ret % 2 == 0) { // 현재 지는 상황
                    if(cnt % 2 == 0) { // 상대도 지면 최대한 오래 버티기
                        ret = Math.max(ret, cnt);
                    } else { // 상대가 이기면 그 경우 선택
                        ret = cnt;
                    }
                } else { // 현재 이기는 상황
                    if(cnt % 2 == 1) { // 상대도 이기면 최대한 빨리 끝내기
                        ret = Math.min(ret, cnt);
                    }
                    // 상대가 지면 현재 선택 유지
                }
            }

            Board[arow][acol] = 1; // 발판 복원
            return ret;
        }
    }

}
