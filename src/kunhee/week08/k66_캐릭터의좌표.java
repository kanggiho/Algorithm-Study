package kunhee.week08;

// https://school.programmers.co.kr/learn/courses/30/lessons/42842

public class k66_캐릭터의좌표 {

    public static int[] solution(String[] keyinput, int[] board) {

        int[] answer = new int[2];

        int xMax = (board[0] - 1) / 2;
        int xMin = -1 * xMax;
        int yMax = (board[1] - 1) / 2;
        int yMin = -1 * yMax;

        for (String input : keyinput) {
            if (input.equals("left")) {
                if (answer[0] > xMin) {
                    answer[0]--;
                }
            } else if(input.equals("right")) {
                if (answer[0] < xMax) {
                    answer[0]++;
                }
            } else if (input.equals("up")) {
                if (answer[1] < yMax) {
                    answer[1]++;
                }
            } else {
                if (answer[1] > yMin) {
                    answer[1]--;
                }
            }
        }

        return answer;
    }

    // 테스트
    public static void main(String[] args) {
        String[] keyinput1 = {"left", "right", "up", "right", "right"};
        int[] board1 = {11, 11};
        int[] result1 = solution(keyinput1, board1);
        System.out.println(java.util.Arrays.toString(result1));

        String[] keyinput2 = {"down", "down", "down", "down", "down"};
        int[] board2 = {7, 9};
        int[] result2 = solution(keyinput2, board2);
        System.out.println(java.util.Arrays.toString(result2));
    }
}