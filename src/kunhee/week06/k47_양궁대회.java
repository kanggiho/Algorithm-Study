package kunhee.week06;

import java.util.Arrays;

public class k47_양궁대회 {

    static int maxDiff = -1; // 최대 점수 차이
    static int[] result = {-1};

    public int[] solution(int n, int[] info) {
        dfs(0, n, new int[11], info);
        return result;
    }

    // DFS 백트래킹
    private void dfs(int index, int arrowsLeft, int[] ryan, int[] appeach) {
        // 화살을 다 쓴 경우
        if (index == 11 || arrowsLeft == 0) {
            // 뒤에서 ryan 배열이 계속 바뀌기 때문에 result도 같이 바뀌어버리는 문제 방지.
            // int[]는 참조형이라, ryan을 그대로 저장하면 result와 ryan이 같은 배열을 가리키게 됨.
            int[] ryanCopy = Arrays.copyOf(ryan, 11);
            if (arrowsLeft > 0) {
                ryanCopy[10] += arrowsLeft; // 남은 화살은 0점에 몰빵
            }

            int rScore = 0, aScore = 0;
            for (int i = 0; i < 11; i++) {
                if (appeach[i] == 0 && ryanCopy[i] == 0) continue;
                if (ryanCopy[i] > appeach[i]) rScore += 10 - i;
                else aScore += 10 - i;
            }

            int diff = rScore - aScore; // 라이언이 이긴 경우만 저장
            if (diff <= 0) return; // 이기지 못하면 무시

            // 더 큰 차이거나, 같으면 낮은 점수를 더 많이 쏜 경우 우선
            if (diff > maxDiff || (diff == maxDiff && isBetter(ryanCopy, result))) {
                maxDiff = diff;
                result = ryanCopy;
            }
            return;
        }

        // 화살을 이 점수에 쏘지 않는 경우
        dfs(index + 1, arrowsLeft, ryan, appeach);

        // 화살을 이 점수에 쏘는 경우, 이 점수를 이기려면 (appeach[index] + 1) 발 필요
        if (arrowsLeft > appeach[index]) {
            ryan[index] = appeach[index] + 1;
            dfs(index + 1, arrowsLeft - ryan[index], ryan, appeach);
            ryan[index] = 0; // 백트래킹
        }
    }

    // 낮은 점수를 더 많이 쏜 배열이 우선
    private boolean isBetter(int[] newResult, int[] oldResult) {
        for (int i = 10; i >= 0; i--) {
            if (newResult[i] > oldResult[i]) return true;
            else if (newResult[i] < oldResult[i]) return false;
        }
        return false;
    }

}
