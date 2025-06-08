package giho.week06;

public class G_삼각달팽이 {
    public int[] solution(int n) {
        int num = n*(n+1)/2;
        int temp = 1;

        int[][] snail = new int[n][n];
        int[] iterator = new int[n];

        int x=0;
        int y=0;

        int[] dx = {0,1,-1};
        int[] dy = {1,0,-1};

        snail[0][0]=1;

        for(int i = 0 ; i < n ; i++){
            iterator[i]=n-i;
        }
        iterator[0]-=1;


        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < iterator[i]; j++){
                x+=dx[i%3];
                y+=dy[i%3];
                temp++;
                snail[y][x]=temp;
            }
        }

        int[] answer = new int[num];
        int iter = 0;
        for(int i=0; i<n;i++){
            for(int j=0;j<=i;j++){
                answer[iter]=snail[i][j];
                iter++;
            }
        }

        return answer;
    }
}
