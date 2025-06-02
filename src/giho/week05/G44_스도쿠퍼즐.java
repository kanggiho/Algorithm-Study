package giho.week05;

public class G44_스도쿠퍼즐 {

    private static final int MAX_SIDE = 9;

    private static int[][] board;

    public static class Position {
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }


    public static void main(String[] args) {
        int[][] test1 =
                {{5, 3, 0, 0, 7, 0, 0, 0, 0},
                        {6, 0, 0, 1, 9, 5, 0, 0, 0},
                        {0, 9, 8, 0, 0, 0, 0, 6, 0},
                        {8, 0, 0, 0, 6, 0, 0, 0, 3},
                        {4, 0, 0, 8, 0, 3, 0, 0, 1},
                        {7, 0, 0, 0, 2, 0, 0, 0, 6},
                        {0, 6, 0, 0, 0, 0, 2, 8, 0},
                        {0, 0, 0, 4, 1, 9, 0, 0, 5},
                        {0, 0, 0, 0, 8, 0, 0, 7, 9}
                };

        int[][] test2 =
                {{0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0}};

        solution(test2);
        findSolution();
        for (int i = 0; i < MAX_SIDE; i++) {
            for (int j = 0; j < MAX_SIDE; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }

    }

    public static int[][] solution(int[][] test) {
        int[][] answer = new int[MAX_SIDE][MAX_SIDE];
        board = test;
        return answer;
    }

    public static boolean findSolution(){
        Position pos = blankPosition();


        if(pos==null){
            return true;
        }

        int row = pos.row;
        int col = pos.col;

        for (int i = 1; i <= MAX_SIDE; i++) {
            if(isValid(pos,i)){
                board[row][col] = i;
                if(findSolution()){
                    return true;
                }
                board[row][col]=0;
            }
        }
        return false;

    }




    public static Position blankPosition(){
        for (int i = 0; i < MAX_SIDE; i++) {
            for (int j = 0; j < MAX_SIDE; j++) {
                if(board[i][j]==0){
                    return new Position(i,j);
                }
            }
        }
        return null;
    }




    public static boolean isValid(Position pos, int num){
        if(inColumn(pos,num)&&inRow(pos,num)&&inBox(pos,num)){
            return true;
        }
        return false;
    }

    public static boolean inColumn(Position pos, int num) {
        for (int i = 0; i < MAX_SIDE; i++) {
            if (board[i][pos.col] == num) return false;
        }
        return true;
    }

    public static boolean inRow(Position pos, int num) {
        for (int i = 0; i < MAX_SIDE; i++) {
            if (board[pos.row][i] == num) return false;
        }
        return true;
    }

    public static boolean inBox(Position pos, int num) {
        int box_X = pos.col / 3;
        int box_Y = pos.row / 3;
        for (int i = box_X * 3; i <= box_X * 3 + 2; i++) {
            for (int j = box_Y * 3; j <= box_Y * 3 + 2; j++) {
                if (board[j][i] == num) return false;
            }
        }
        return true;
    }
}
































