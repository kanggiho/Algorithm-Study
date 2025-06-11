package giho.week07;

public class G61_달팽이수열 {
    public static void main(String[] args) {
        int n = 10;
        int[][] ansArr = solution(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(ansArr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int[][] solution(int n){
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        int x = 0;
        int y = 0;

        int count = 1;

        int pos = 0;

        int[][] newArr = new int[n][n];
        boolean[][] visited = new boolean[n][n];

        visited[y][x] = true;
        newArr[y][x] = count;
        count++;

        while(count<=n*n){
            int nx,ny;
            int position = pos%4;


            nx = x+dx[position];
            ny = y+dy[position];

            if(nx<0||nx>=n||ny<0||ny>=n){
                pos++;
                continue;
            }
            if(visited[ny][nx]){
                pos++;
                continue;
            }

            visited[ny][nx] = true;

            y = ny;
            x = nx;

            newArr[y][x] = count++;
        }

        return newArr;
    }
}
