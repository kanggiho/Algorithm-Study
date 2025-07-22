package giho.review.stack;

public class RG09_10진수를2진수로변환하기 {
    public static void main(String[] args) {
        int test1 = 10;
        int test2 = 27;
        int test3 = 12345;

        System.out.println(solution(test1));
        System.out.println(solution(test2));
        System.out.println(solution(test3));
    }

    public static String solution(int n){
        return Integer.toBinaryString(n);
    }
}
