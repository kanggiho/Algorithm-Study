package kunhee.week07;

public class K57_지형이동 {

    public static int solution(int[][] land, int height) {
        int answer = 0;
        return answer;
    }

    // 테스트
    public static void main(String[] args) {
        int[][] land1 = {{1, 4, 8, 10}, {5, 5, 5, 5}, {10, 10, 10, 10}, {10, 10, 10, 20}};
        int height1 = 3;
        int[][] land2 = {{10, 11, 10, 11}, {2, 21, 20, 10}, {1, 20, 21, 11}, {2, 1, 2, 1}};
        int height2 = 1;

        System.out.println(solution(land1, height1));
        System.out.println(solution(land2, height2));
    }
}