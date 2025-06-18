package giho.week07;

public class G70_피보나치수 {
    public static void main(String[] args) {

        System.out.println(solution(10));
    }

    public static int solution(int n) {
        int[] fibo = new int[n + 1];

        fibo[0] = 0;
        fibo[1] = 1;
        for (int i = 2; i < fibo.length; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }
        return fibo[n];
    }
}
