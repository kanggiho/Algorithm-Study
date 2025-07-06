package kunhee.week08;

/*
문제 설명:
n을 입력받아 nxn 크기의 2차원 배열을 생성하여 달팽이 수열을 채우는 solution() 함수를 구현하세요.
달팽이 수열은 다음과 같이 숫자 1부터 시작하여 시계 방향 나선형으로 채우는 수열을 말합니다.

제약조건:
- n은 2 이상 10 미만의 자연수입니다.
- 숫자는 배열의 첫 번째 행, 첫 번째 열에서 시작합니다.
*/


import java.util.Arrays;

public class K61_달팽이수열만들기 {

    public static int[][] solution(int n) {

        int[][] arr = new int[n][n];
        int startRow = 0;
        int startCol = 0;
        int endRow = n - 1;
        int endCol = n - 1;
        int x = 1;

        while (x <= n * n) {

            // 오른쪽으로
            for (int i = startCol; i <= endCol; i++) {
                arr[startRow][i] = x++;
            }
            startRow++; // 윗줄 끝났으니 한 칸 아래로

            // 아래로
            for (int i = startRow; i <= endRow; i++) {
                arr[i][endCol] = x++;
            }
            endCol--; // 오른쪽 줄 끝났으니 한 칸 왼쪽으로

            // 왼쪽으로
            for (int i = endCol; i >= startCol; i--) {
                arr[endRow][i] = x++;
            }
            endRow--; // 아래쪽 줄 끝났으니 한 칸 위로

            // 위로
            for (int i = endRow; i >= startRow; i--) {
                arr[i][startCol] = x++;
            }
            startCol++; // 왼쪽 줄 끝났으니 한 칸 오른쪽으로

        }

        return arr;
    }

    // 테스트
    public static void main(String[] args) {
        int n1 = 3;

        int n2 = 4;

        System.out.println(Arrays.deepToString(solution(n1)));
        System.out.println(Arrays.deepToString(solution(n2)));
    }
}