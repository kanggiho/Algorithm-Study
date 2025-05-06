package heonwoo.week04;

public class H_택배상자꺼내기 {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int cnt = -1;
        int next = 0;
        int[][] arr = new int[(n/w)+1][w];

        // n=22, w=6, num=8
        for (int i = 0; i < n; i++){
            if (i % w == 0){
                cnt++; //다음 행으로 넘어가는경우
                next++; // 홀짝으로 바로 밑의 행의 경우 체크
            }
            int row = (next % 2 == 1) ? (w - 1) - (i % w) : i % w;
            arr[cnt][row] = i + 1;
        }

        int target = -1;
        int target2 = -1;
        for (int i = 0; i <arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                if (arr[i][j] == num){
                    target = j;
                    target2= i;
                    break;
                }
            }
        }
        for(int i = target2; i < arr.length && arr[i][target] != 0; i++){
            answer++;
            if (arr[i][target] == 0){
                break;
            }
        }


        return answer;
    }
}