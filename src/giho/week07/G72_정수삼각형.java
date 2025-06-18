package giho.week07;

public class G72_정수삼각형 {

    public int solution(int[][] triangle) {
        for (int i = triangle.length - 1; i >= 0; i--) {
            for (int j = 1 ; j < triangle[i].length; j++) {
                triangle[i-1][j-1] += Math.max(triangle[i][j-1],triangle[i][j]);
            }
        }
        return triangle[0][0];
    }
}
