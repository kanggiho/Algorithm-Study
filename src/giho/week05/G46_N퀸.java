package giho.week05;

public class G46_N퀸 {

    static final int N = 6;
    static int[] board;
    static int count = 0;



    public static int solution(int n){
        board = new int[N];
        solve(0);
        return count;
    }


    public static void solve(int row) {
        if (row == N) {
            count++;
            printBoard();
            return;
        }
        for (int col = 0; col < N; col++) {
            if (isSafe(row, col)) {
                board[row] = col;
                solve(row + 1);
            }
        }

    }

    public static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            //같은 위치거나 대각선에 있으면
            if (board[i] == col || Math.abs(board[i] - col) == row - i) {
                return false;
            }
        }
        return true;
    }

    public static void printBoard() {
        for (int i = 0; i < N; i++) {
            System.out.println();
            for (int j = 0; j < N; j++) {
                if(board[i]==j){
                    System.out.print("* ");
                }else{
                    System.out.print("- ");
                }
            }
        }

        System.out.println();

    }

    public static void main(String[] args) {
        solution(N);
        System.out.println(count);
    }
}
